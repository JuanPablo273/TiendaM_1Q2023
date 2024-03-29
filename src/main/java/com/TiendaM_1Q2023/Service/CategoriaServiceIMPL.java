
package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.Dao.CategoriaDao;
import com.TiendaM_1Q2023.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceIMPL implements CategoriaService  {
    
    @Autowired
    CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public  List<Categoria> getCategorias(boolean activos) {
       List<Categoria> lista =(List<Categoria>) categoriaDao.findAll(); //4 =3A y 1I
       
       if(activos == true){
           lista.removeIf(e -> !e.isActivo()); //3 = 3A
           
       }
       
       return lista;
    }
    

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse( null);
    }
    
    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
        
    }
    

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }

 
   

}