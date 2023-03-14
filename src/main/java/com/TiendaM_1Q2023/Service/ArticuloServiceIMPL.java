package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.Dao.ArticuloDao;
import com.TiendaM_1Q2023.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceIMPL implements ArticuloService  {
    
    @Autowired
    ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true)
    public  List<Articulo> getArticulos(boolean activos) {
       List<Articulo> lista =(List<Articulo>) articuloDao.findAll(); //4 =3A y 1I
       
       if(activos == true){
           lista.removeIf(e -> !e.isActivo()); //3 = 3A
           
       }
       
       return lista;
    }
    

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse( null);
    }
    
    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
        
    }
    

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }

    

   

}