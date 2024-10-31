package com.br.eteixeira.estoqueJava.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eteixeira.estoqueJava.model.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
}
