package com.br.eteixeira.estoqueJava.service;

import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eteixeira.estoqueJava.model.domain.Usuario;
import com.br.eteixeira.estoqueJava.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvaUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscaUsuarioPorNome(String usuario){
        return Optional.ofNullable(usuarioRepository.findByUsuario(usuario));
    }

    public Boolean verificaTamanhoSenha(String senha){
        return senha.length() >= 8;
    }

    public void alertaUsuarioErro(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void alertaUsuario(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
    }
}
