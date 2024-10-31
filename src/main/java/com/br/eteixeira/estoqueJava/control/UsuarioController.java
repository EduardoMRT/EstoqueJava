package com.br.eteixeira.estoqueJava.control;

import java.awt.event.ActionEvent;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.eteixeira.estoqueJava.model.SessaoUsuario;
import com.br.eteixeira.estoqueJava.model.domain.Usuario;
import com.br.eteixeira.estoqueJava.model.service.UsuarioService;
import com.br.eteixeira.estoqueJava.view.InicialView;

@Controller
public class UsuarioController {
	
    private final InicialView view;
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(InicialView view, UsuarioService usuarioService) {
        this.view = view;
        this.usuarioService = usuarioService;
        configurarEventos();
    }

    private void configurarEventos() {
        this.view.getBtnEntrar().addActionListener(this::fazerLogin);
    }

    private void fazerLogin(ActionEvent e) {
        String username = view.getUsuarioField().getText();
        String senha = String.valueOf(view.getSenhaField().getPassword());


        try {
            if(!usuarioService.verificaTamanhoSenha(senha)) {
                usuarioService.alertaUsuario("A sua senha deve conter no mínimo (6) seis caracteres!");
                throw new Exception();
            }
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        usuario.setSenha(usuarioService.criptografaSenhaUsuario(senha));

        if(usuarioService.verificaUsuario(usuario)){
            SessaoUsuario.setUsuarioLogado(usuario);
            System.out.println("Usuário Logado: " + SessaoUsuario.getUsuarioLogado().getUsuario());
        }

    }

    public void cadastraUsuario(String username, String senha){
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        usuario.setSenha(usuarioService.criptografaSenhaUsuario(senha));
        usuarioService.cadastraUsuario(usuario);
    }
   
}
