package com.br.eteixeira.estoqueJava.model;

import com.br.eteixeira.estoqueJava.model.domain.Usuario;
import lombok.Getter;
import lombok.Setter;


public class SessaoUsuario {
    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        SessaoUsuario.usuarioLogado = usuarioLogado;
    }
}
