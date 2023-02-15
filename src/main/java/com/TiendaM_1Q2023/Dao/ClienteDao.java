/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TiendaM_1Q2023.Dao;

import com.TiendaM_1Q2023.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author XPC
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
    
}
