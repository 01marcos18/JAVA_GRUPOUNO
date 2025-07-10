package pe.com.csubuaste.webapp.domain.data.Implement;

import pe.com.csubuaste.webapp.domain.data.entity.Estado;
import pe.com.csubuaste.webapp.domain.data.repository.IRepositoryBase;
import pe.com.csubuaste.webapp.domain.general.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoImpl implements IRepositoryBase<Estado> {
    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConnection();
    }

    @Override
    public List<Estado> listar() {
        List<Estado> lstEstado = new ArrayList<>();
        String sql = "SELECT idEstado,descripcion,estado,fechaCreacion,fechaActualizacion FROM estado where estado=1 ";

        try (
                Connection conn = getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
        ) {
            while (rs.next()) {
                Estado es = CreateObjectEstado(rs);
                lstEstado.add(es);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lstEstado;
    }

    @Override
    public Estado porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Estado estado) {
        String sql;
        if (estado.getIdEstado() != 0 && estado.getIdEstado()>0){
            sql="UPDATE estado SET descripcion=?,estado=?,fechaActualizacion=? WHERE idEstado=?";
        }else{
            sql="INSERT INTO estado(descripcion,estado, fechaCreacion, fechaActualizacion) VALUES (?,?,?,?)";
        }
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ){
            ps.setString(1,estado.getDescripcion());
            ps.setBoolean(2,estado.isEstado());

            if (estado.getIdEstado() != 0 && estado.getIdEstado()>0) {
                ps.setDate(3, new Date(estado.getFechaActualizacion().getTime()));
                ps.setInt(4,estado.getIdEstado());
            }else{
                ps.setDate(3,new Date(estado.getFechaCreacion().getTime()));
                ps.setDate(4,new Date(estado.getFechaActualizacion().getTime()));
            }

            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id,boolean estado) {
        String sql="UPDATE estado set estado=? where idEstado=?";
        try(
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ){

            ps.setBoolean(1, estado);
            ps.setInt(2, id.intValue());
            ps.executeUpdate();
            
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private Estado CreateObjectEstado(ResultSet rs) throws SQLException {
        Estado es = new Estado();
        es.setIdEstado(rs.getInt("idEstado"));
        es.setDescripcion(rs.getString("descripcion"));
        es.setEstado(rs.getBoolean("estado"));
        es.setFechaCreacion(rs.getDate("fechaCreacion"));
        es.setFechaActualizacion(rs.getDate("fechaActualizacion"));
        return es;
    }
}
