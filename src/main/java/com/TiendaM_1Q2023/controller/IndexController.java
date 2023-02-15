/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.TiendaM_1Q2023.controller;

import com.TiendaM_1Q2023.domain.Cliente;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.TiendaM_1Q2023.Dao.ClienteDao;
/**
 *
 * @author XPC
 */

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    ClienteDao clienteDao;
    
    
    
    @GetMapping("/")
    public String inicio(Model model) {
     //   log.info("Ahora desde mvc");
       // model.addAttribute("Mensaje", "Hola desde el controlador");
        
        //Cliente cliente = new Cliente("Jonathan", "Brenes Blanco","hasddsa@gmail.com","91238213");
          //      model.addAttribute("cliente",cliente);
                
                
            //    Cliente cliente2 = new Cliente("Jonathan", "Brenes Blanco","hasddsa@gmail.com","91238213");
              //  Cliente cliente3 = new Cliente("Jonathan", "Brenes Blanco","hasddsa@gmail.com","91238213");
                
                //List<Cliente> clientes = Arrays.asList(cliente, cliente2, cliente3);
                var clientes = clienteDao.findAll();
                model.addAttribute("clientes", clientes);
                
        return "index";
    }
    
}
