
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.domain.Credito;
import java.util.List;


public interface CreditoService {
    
      public List<Credito> getCredito(boolean activos);
    
    public Credito getCredito(Credito credito);
    
    public void save(Credito credito); // Para insertar o modificar (si viene el idCliente o no)
    
    public void delete(Credito credito);
    
}
