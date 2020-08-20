public class RoutesGen {

    private static int global_route_id = 1;

    private static String build_route(String code, int ap_from, int ap_to, int p_id, int[] days) {
        StringBuilder b = new StringBuilder();
        for (int day : days) {
            b.append("        <insert tableName=\"route\">\n");
            b.append("            <column name=\"id\">").append(global_route_id).append("</column>\n");
            b.append("            <column name=\"code\">").append(code).append("</column>\n");
            b.append("            <column name=\"departure_airport_id\">").append(ap_from).append("</column>\n");
            b.append("            <column name=\"arrival_airport_id\">").append(ap_to).append("</column>\n");
            b.append("            <column name=\"airplane_id\">").append(p_id).append("</column>\n");
            b.append("            <column name=\"day_of_week\">").append(day).append("</column>\n");
            b.append("        </insert>");
            b.append("\n");
            global_route_id++;
        }
        return b.toString();
    }


    public static void main(String[] args) {

        String b = build_route("M1", 1, 4, 1, new int[]{1, 2, 3, 4, 5, 6, 7}) +
                build_route("M1", 1, 4, 2, new int[]{1, 2, 3, 4, 5, 6, 7}) +
                build_route("M1", 4, 1, 1, new int[]{1, 2, 3, 4, 5, 6, 7}) +
                build_route("M1", 4, 1, 2, new int[]{1, 2, 3, 4, 5, 6, 7}) +
                build_route("M2", 2, 5, 3, new int[]{1, 2, 3, 4, 5, 6, 7}) +
                build_route("M2", 5, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7}) +
                build_route("M3", 4, 3, 4, new int[]{6}) +
                build_route("M3", 3, 5, 5, new int[]{6}) +
                build_route("M3", 5, 3, 5, new int[]{7}) +
                build_route("M3", 3, 4, 4, new int[]{7});
        System.out.print(b);
    }
}
