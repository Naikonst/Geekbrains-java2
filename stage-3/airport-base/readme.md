1. Для создания базы данных (БД) и наполения ее данными необходимо изменить настройки в конфигурационном файле
```
src/main/resources/liquibase/liquibase.properties
src/main/resources/application.properties
```
После чего выполить команду

```
mvn liquibase:update
```

2. Процедура формирования отчета

```
CREATE OR REPLACE FUNCTION public.get_landing_report(
   IN t_arrival_airport_id BIGINT
) RETURNS SETOF record AS
$$
DECLARE
   rec record;
   BEGIN
      FOR rec IN
         select airport.code as airport_code,
                airport.name as airport_name,
                (select concat(brand, ' ', model, ' №', number) from airplane where id = route.airplane_id) as airplane,
                count(airplane_id) as landing_count
             from route,
                airport
             where route.arrival_airport_id = t_arrival_airport_id
                and airport.id = route.arrival_airport_id
             group by airport.code, airport.name, airplane_id
      LOOP
         RETURN NEXT rec;
      END LOOP;
      RETURN;
   END;
$$
LANGUAGE  plpgsql;
```


3. После создания БД необходимо изменить настройки подключения к Tomcat'у в корневом pom.xml

```
    <tomcat.url>http://localhost:8080/manager/text</tomcat.url>
    <tomcat.username>admin</tomcat.username>
    <tomcat.password>admin</tomcat.password>
    <tomcat.path>/airlines</tomcat.path>
```

4. Для сборки приложения и прогона тестов(используется Spring Boot), а также установки на сервер приложений Tomcat необходимо выполнить следующую команду:

```
mvn tomcat7:deploy
```

5. При указанных настройка по адресу ниже отобразиться приветственная страница

```
http://localhost:8080/airlines
```

6. Для формирования отчета используются международные коды Аэропортов. Отчет формируется при отправке запроса на адрес
```
http://localhost:8080/airlines/api/airport/{airport-code}/landing
```

Список аэропортов доступен по адресу:

```
http://localhost:8080/airlines/api/airport
```

Детальная информаци по аэропорту доступна по адресу:
```
http://localhost:8080/airlines/api/airport/{airport-code}
```