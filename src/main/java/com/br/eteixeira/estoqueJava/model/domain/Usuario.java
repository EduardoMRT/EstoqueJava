package com.br.eteixeira.estoqueJava.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 50)
    private String usuario;

    @Column(nullable = false, length = 256)
    private String senha;

    @Column(nullable = true, length = 256)
    private String SenhaTemp;

    public Usuario(){

    }

}
