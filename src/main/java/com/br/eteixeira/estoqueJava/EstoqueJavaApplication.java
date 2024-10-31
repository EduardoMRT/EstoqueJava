package com.br.eteixeira.estoqueJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.br.eteixeira.estoqueJava.view.InicialView;

@SpringBootApplication
@ComponentScan(basePackages = "com.br.eteixeira.estoqueJava")
public class EstoqueJavaApplication {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        ApplicationContext context = SpringApplication.run(EstoqueJavaApplication.class, args);

        InicialView view = context.getBean(InicialView.class);
        view.setVisible(true);
    }
}

