package pe.com.csubuaste.webapp.domain.general.builder.sql;

public interface IQueryBuilder {
    IQueryBuilder Select(String columns);
    IQueryBuilder From(String table);
    IQueryBuilder Where(String condition);
    IQueryBuilder OrderBy(String column);
    IQueryBuilder GroupBy(String column);
    IQueryBuilder Limit(int limit);
    SqlQuery Build();
}
