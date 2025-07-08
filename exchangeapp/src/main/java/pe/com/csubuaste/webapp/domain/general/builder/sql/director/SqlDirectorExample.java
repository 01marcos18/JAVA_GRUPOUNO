package pe.com.csubuaste.webapp.domain.general.builder.sql.director;

import pe.com.csubuaste.webapp.domain.general.builder.sql.IQueryBuilder;
import pe.com.csubuaste.webapp.domain.general.builder.sql.SqlQuery;

public class SqlDirectorExample {
    private static IQueryBuilder queryBuilder;

    public SqlDirectorExample(IQueryBuilder queryBuilder) {
        SqlDirectorExample.queryBuilder = queryBuilder;
    }

    public SqlQuery contratoPedido(String companiasocio, String contrato) {
        return queryBuilder
                .Select("CO.fechadocumento, CO.pedido, CO_ContratoDetalle.Tamano, CO_ContratoDetalle.PrecioUnitario, CO.documentointerno, CO.FechaDocumento")
                .From("co_contrato CO INNER JOIN CO_ContratoDetalle ON CO.CompaniaSocio = CO_ContratoDetalle.CompaniaSocio AND CO.NumeroContrato = CO_ContratoDetalle.NumeroContrato")
                .Where("CO.companiasocio = " + companiasocio)
                .Where("CO.numerocontrato = '" + contrato.trim() + "'")
                .Build();
    }

    public SqlQuery obtenerPrecioUnitarioFinalPedido(String companiasocio, String pedido) {
        return queryBuilder
                .Select("PrecioUnitarioFinal")
                .From("co_documentodetalle")
                .Where("companiasocio = '" + companiasocio + "'")
                .Where("numerodocumento = '" + pedido + "'")
                .Where("tipodocumento='PE'")
                .Build();
    }

    public SqlQuery obtenerSocioTope(String codProyecto, double preciorango) {
        return queryBuilder
                .Select("*")
                .From("PS_SociosTope")
                .Where("cod_proyec = '" + codProyecto + "'")
                .Where("'" + preciorango + "' >= rango1")
                .Where("'" + preciorango + "' <= rango2")
                .Build();
    }
}
