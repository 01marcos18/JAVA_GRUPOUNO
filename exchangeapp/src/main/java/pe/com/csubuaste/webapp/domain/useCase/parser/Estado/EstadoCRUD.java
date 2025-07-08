package pe.com.csubuaste.webapp.domain.useCase.parser.Estado;

import pe.com.csubuaste.webapp.domain.data.Implement.EstadoImpl;
import pe.com.csubuaste.webapp.domain.data.entity.Estado;
import pe.com.csubuaste.webapp.domain.data.repository.IRepositoryBase;

import java.util.List;

public class EstadoCRUD implements IRepositoryBase<Estado> {
    private EstadoImpl impl;
    public EstadoCRUD() {
        this.impl = new EstadoImpl();
    }

    @Override
    public List<Estado> listar() {
        return impl.listar();
    }

    @Override
    public Estado porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Estado estado) {
        impl.guardar(estado);
    }

    @Override
    public void eliminar(Long id,boolean estado) {
        impl.eliminar(id,estado);
    }
}
