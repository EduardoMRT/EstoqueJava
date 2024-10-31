package com.br.eteixeira.estoqueJava.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.br.eteixeira.estoqueJava.service.UsuarioService;
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
        String usuario = view.getUsuarioField().getText();
        String senha = String.valueOf(view.getSenhaField().getPassword());

        if(!usuarioService.verificaTamanhoSenha(senha)) {
        	usuarioService.alertaUsuario("A sua senha deve conter no mínimo oito caracteres!");
        }
        
        
        
    }


   
}
