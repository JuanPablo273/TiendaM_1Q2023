
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.domain.Carrito;


public interface CarritoService {
    
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getcarritoCliente(Long idCliente);
    
}
