package pe.com.csubuaste.webapp.domain.general.builder.sql;

import java.util.ArrayList;
import java.util.List;

public class SqlQueryBuilder implements IQueryBuilder {
    private SqlQuery query = new SqlQuery();

    @Override
    public IQueryBuilder Select(String columns) {
        query.setSelect(columns);
        return this;
    }

    @Override
    public IQueryBuilder From(String table) {
        query.setFrom(table);
        return this;
    }

    @Override
    public IQueryBuilder Where(String condition) {
        query.getWhere().add(condition);
        return this;
    }

    @Override
    public IQueryBuilder OrderBy(String column) {
        query.getOrderBy().add(column);
        return this;
    }

    @Override
    public IQueryBuilder GroupBy(String column) {
        query.setGroupBy(column);
        return this;
    }

    @Override
    public IQueryBuilder Limit(int limit) {
        query.setLimit(limit);
        return this;
    }

    @Override
    public SqlQuery Build() {
        return query;
    }
}