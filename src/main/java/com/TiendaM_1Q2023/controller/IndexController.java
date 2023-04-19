
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
import com.TiendaM_1Q2023.Dao.UsuarioDao;
import com.TiendaM_1Q2023.Service.ArticuloService;
import com.TiendaM_1Q2023.Service.CarritoDetalleService;
import com.TiendaM_1Q2023.Service.CarritoService;
import com.TiendaM_1Q2023.domain.Carrito;
import com.TiendaM_1Q2023.domain.CarritoDetalle;
import com.TiendaM_1Q2023.domain.Usuario;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {
    
    @Autowired
    ArticuloService articuloService;
    
    
    @Autowired
    UsuarioDao usuarioDao;
    
     @Autowired
     CarritoService carritoService;
     
     @Autowired
     CarritoDetalleService carritoDetalleService;
    
    
    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {
        
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        
        
        if(principal instanceof UserDetails){
            user = (UserDetails)principal;
        }
            //Validar si esta logeago y si es un usuario de un cliente
            boolean esCliente = false;
            
            if(user !=null){
                //cONSUTLAR LOS DETALLES DE USUARIO
                Usuario usuario = usuarioDao.findByUsername(user.getUsername());
                
                
                //Validar si el usuario es de un cliente
                if(usuario.getIdCliente() !=null && usuario.getIdCliente()!= 0){
                    esCliente = true;
                    
                    Carrito carrito = carritoService.getcarritoCliente(usuario.getIdCliente());
                    
                    //Guardamos en sesion los valores importantes
                    request.getSession().setAttribute("idCliente", usuario.getIdCliente());
                    request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
                    request.getSession().setAttribute("idCliente", esCliente);
                    
                    //Consultar items del carrito
                    
                    List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
                    model.addAttribute("cantidadArticulosCarrito", carritoDetalles.size());

                }
            }
       
                var articulos = articuloService .getArticulos(true);
                model.addAttribute("articulos", articulos);
                model.addAttribute("esCliente", esCliente);
                
        return "index";
    }
    
}
