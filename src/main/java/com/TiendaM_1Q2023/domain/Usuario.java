package com.TiendaM_1Q2023.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idUsuario; // hibernate lo transforma id_cliente
    
    
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @JoinColumn(name ="id_usuario")
    @OneToMany
    private List<Rol> roles;
    
}
