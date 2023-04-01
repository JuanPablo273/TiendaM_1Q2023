
package com.TiendaM_1Q2023.Dao;

import com.TiendaM_1Q2023.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
   
   public List<Cliente> findByNombre(String nombre);
    
   public List<Cliente> findByTelefono(String telefono);
   
   public List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);

    
}
