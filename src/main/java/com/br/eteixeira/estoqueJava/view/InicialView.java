package com.br.eteixeira.estoqueJava.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class InicialView extends  JFrame{

    private JPasswordField senhaField;
    private JTextField usuarioField;
    private JButton btnEntrar;

    public InicialView(){
        setTitle("Inicio");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 200));

        usuarioField = new JTextField();
        usuarioField.setPreferredSize(new Dimension(200, 30));
        JLabel usuarioLabel = new JLabel("Usuario: ");

        senhaField = new JPasswordField();
        senhaField.setPreferredSize(new Dimension(200, 30));
        JLabel senhaLabel = new JLabel("Senha: ");

        btnEntrar = new JButton("Entrar");

        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnEntrar);

        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

    }

}
