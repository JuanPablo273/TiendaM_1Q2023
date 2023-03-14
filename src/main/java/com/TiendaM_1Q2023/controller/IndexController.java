
package com.TiendaM_1Q2023.controller;

import com.TiendaM_1Q2023.domain.Articulo;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.TiendaM_1Q2023.Dao.ArticuloDao;
import com.TiendaM_1Q2023.Service.ArticuloService;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ArticuloService articuloService;
    
    
    
    @GetMapping("/")
    public String inicio(Model model) {
       log.info("Ahora desde MVC");
       
                var articulos = articuloService .getArticulos(true);
                model.addAttribute("articulos", articulos);
                
        return "index";
    }
    
}
