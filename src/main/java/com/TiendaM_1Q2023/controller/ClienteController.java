
package com.TiendaM_1Q2023.controller;

import com.TiendaM_1Q2023.Service.ClienteService;
import com.TiendaM_1Q2023.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClienteController {
    
  @Autowired
    ClienteService clienteService;
    
    
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes=clienteService.getClientes();
        
        var limiteTotal=0;
        for (var c: clientes) {
            limiteTotal+=c.getCredito().getLimite();
        }
        model.addAttribute("limiteTotal",limiteTotal);
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modificarCliente";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
    cliente = clienteService.getCliente(cliente);
    
    
            model.addAttribute("cliente", cliente);
            return "/cliente/modificarCliente";

    }
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
     clienteService.delete(cliente);
            return "redirect/cliente/listado";
    }
    
  
  @GetMapping("/cliente/buscar")
    public String buscar(Cliente cliente){
        return "/cliente/buscarCliente";
    }
    
 @PostMapping ("/cliente/busqueda")
 public String busqueda(Cliente cliente, Model model){
     var clientes = clienteService.getClientePorNombre(cliente.getNombre());
     model.addAttribute("resultados",clientes);
     return "/cliente/buscarCliente";
     
 }
}

