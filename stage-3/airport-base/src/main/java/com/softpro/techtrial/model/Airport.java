package com.softpro.techtrial.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="airport")
public class Airport implements Serializable {

    private static final long serialVersionUID = -575347909928592140L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 5)
    private String code;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (id != null ? !id.equals(airport.id) : airport.id != null) return false;
        if (code != null ? !code.equals(airport.code) : airport.code != null) return false;
        if (city != null ? !city.equals(airport.city) : airport.city != null) return false;
        return name != null ? name.equals(airport.name) : airport.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
