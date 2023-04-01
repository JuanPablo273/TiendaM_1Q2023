
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente); // Para insertar o modificar (si viene el idCliente o no)
    
    public void delete(Cliente cliente);
    
    public List<Cliente> getClientePorNombre(String nombre);
    
    public List<Cliente> getClientePorTelefono(String telefono);
    
    public List<Cliente> getClientePorNombreApellidos(String nombre, String apellidos);
    
}
