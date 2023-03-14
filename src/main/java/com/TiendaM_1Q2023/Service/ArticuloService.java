
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo); // Para insertar o modificar (si viene el idCliente o no)
    
    public void delete(Articulo articulo);
    
}
