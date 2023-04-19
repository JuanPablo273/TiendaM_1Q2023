
package com.TiendaM_1Q2023.Dao;

import com.TiendaM_1Q2023.domain.Carrito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface CarritoDao extends CrudRepository<Carrito, Long>{
    
    Optional<Carrito> findByIdCliente(Long idCliente); // METODO PARA QUE DEVUELVA O NO UN ID DE CLIENTE AL PEDIRLO
    
}
