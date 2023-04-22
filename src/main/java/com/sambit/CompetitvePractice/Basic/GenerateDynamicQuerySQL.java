package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/04/2023 - 10:55 AM
 */
public class GenerateDynamicQuerySQL {
    public static String selectQuery(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String selectQuery(String tableName, String whereClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause, String withClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause + " WITH " + withClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause, String withClause, String nowaitClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause + " WITH " + withClause + " NOWAIT " + nowaitClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause, String withClause, String nowaitClause, String skipClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause + " WITH " + withClause + " NOWAIT " + nowaitClause + " SKIP " + skipClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause, String withClause, String nowaitClause, String skipClause, String updateClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause + " WITH " + withClause + " NOWAIT " + nowaitClause + " SKIP " + skipClause + " UPDATE " + updateClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause, String withClause, String nowaitClause, String skipClause, String updateClause, String shareClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause + " WITH " + withClause + " NOWAIT " + nowaitClause + " SKIP " + skipClause + " UPDATE " + updateClause + " SHARE " + shareClause;
    }

    public static String selectQuery(String tableName, String whereClause, String orderByClause, String groupByClause, String havingClause, String limitClause, String offsetClause, String fetchClause, String forClause, String onlyClause, String withClause, String nowaitClause, String skipClause, String updateClause, String shareClause, String keyshareClause) {
        return "SELECT * FROM " + tableName + " WHERE " + whereClause + " ORDER BY " + orderByClause + " GROUP BY " + groupByClause + " HAVING " + havingClause + " LIMIT " + limitClause + " OFFSET " + offsetClause + " FETCH " + fetchClause + " FOR " + forClause + " ONLY " + onlyClause + " WITH " + withClause + " NOWAIT " + nowaitClause + " SKIP " + skipClause + " UPDATE " + updateClause + " SHARE " + shareClause + " KEYSHARE " + keyshareClause;
    }

    public static void main(String[] args) {
        System.out.println(selectQuery("table", "where", "order", "group", "having", "limit", "offset", "fetch", "for", "only", "with", "nowait", "skip", "update", "share", "keyshare"));
    }
}
