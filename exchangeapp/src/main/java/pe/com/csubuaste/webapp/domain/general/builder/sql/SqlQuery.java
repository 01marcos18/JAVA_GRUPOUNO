package pe.com.csubuaste.webapp.domain.general.builder.sql;

import java.util.ArrayList;
import java.util.List;

public class SqlQuery {
    private String select;
    private String from;
    private List<String> where = new ArrayList<>();
    private List<String> orderBy = new ArrayList<>();
    private String groupBy;
    private Integer limit;

    // Getters and Setters
    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getWhere() {
        return where;
    }

    public void setWhere(List<String> where) {
        this.where = where;
    }

    public List<String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<String> orderBy) {
        this.orderBy = orderBy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        StringBuilder query = new StringBuilder("SELECT " + select + " FROM " + from);

        if (!where.isEmpty()) {
            query.append(" WHERE ").append(String.join(" AND ", where));
        }

        if (groupBy != null && !groupBy.isEmpty()) {
            query.append(" GROUP BY ").append(groupBy);
        }

        if (!orderBy.isEmpty()) {
            query.append(" ORDER BY ").append(String.join(", ", orderBy));
        }

        if (limit != null) {
            query.append(" LIMIT ").append(limit);
        }

        return query.toString();
    }
}
