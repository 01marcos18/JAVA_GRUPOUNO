package pe.com.csubuaste.webapp.domain.data.repository;

import java.util.List;

public interface IRepositoryBase<T> {
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id,boolean estado);
}
