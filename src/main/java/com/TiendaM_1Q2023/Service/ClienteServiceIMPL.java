
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.Dao.ClienteDao;
import com.TiendaM_1Q2023.Dao.CreditoDao;
import com.TiendaM_1Q2023.domain.Cliente;
import com.TiendaM_1Q2023.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ClienteServiceIMPL implements ClienteService {
    
    
    @Autowired
    ClienteDao clienteDao;
    
     @Autowired
     CreditoDao creditoDao;
    
    

    @Override
    @Transactional(readOnly = true)
    public  List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse( null);
    }
    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
         credito = creditoDao.save(credito);
         
         cliente.setCredito(credito);
         clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
    @Override
    public List<Cliente> getClientePorNombre(String nombre){
    return clienteDao.findByNombre(nombre);
    
    }
    
    @Override
    public List<Cliente> getClientePorTelefono(String telefono){
    return clienteDao.findByTelefono(telefono);
    
    }
    
    @Override
    public List<Cliente> getClientePorNombreApellidos(String nombre, String apellidos){
    return clienteDao.findByNombreAndApellidos(nombre, apellidos);

  
    }

}
