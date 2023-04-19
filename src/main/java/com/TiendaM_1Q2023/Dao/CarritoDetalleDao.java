
package com.TiendaM_1Q2023.Dao;

import com.TiendaM_1Q2023.domain.Articulo;
import com.TiendaM_1Q2023.domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long>{
    
    List<CarritoDetalle> findByIdCarrito(Long idCliente);
    
    CarritoDetalle findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    
    void deleteByIdCarrito(Long  idcarrito);
    
}
