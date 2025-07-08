package pe.com.csubuaste.webapp.domain.general.builder.sql.director;

import pe.com.csubuaste.webapp.domain.general.builder.sql.IQueryBuilder;
import pe.com.csubuaste.webapp.domain.general.builder.sql.SqlQuery;

public class SqlDirectorEstado {
    private static IQueryBuilder queryBuilder;

    public SqlDirectorEstado(IQueryBuilder queryBuilder) {
        SqlDirectorEstado.queryBuilder = queryBuilder;
    }

    public SqlQuery ListarEstado(){
        return queryBuilder
                .Select("*")
                .From("estado")
                .Build();
    }
}
