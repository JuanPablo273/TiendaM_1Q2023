
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
     public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); // Para insertar o modificar (si viene el idCliente o no)
    
    public void delete(Categoria categoria);
    
}
