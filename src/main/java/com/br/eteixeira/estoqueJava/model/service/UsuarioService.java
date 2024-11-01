package com.br.eteixeira.estoqueJava.model.service;

import java.util.Optional;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;
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

    public void cadastraUsuario(Usuario usuario){
        if(verificaUsuarioCadastro(usuario)){
            usuarioRepository.save(usuario);
        }else{
            this.alertaUsuarioErro("Nome de usuário indisponível!");
        }
    }

    public Optional<Usuario> buscaUsuarioPorNome(String usuario){
        return Optional.ofNullable(usuarioRepository.findByUsuario(usuario));
    }

    public Boolean verificaTamanhoSenha(String senha){
        return senha.length() >= 6;
    }

    public void alertaUsuarioErro(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void alertaUsuario(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public Boolean verificaUsuario(Usuario usuario){
        Optional<Usuario> usuarioBancoOpt = this.buscaUsuarioPorNome(usuario.getUsuario());
        if(usuarioBancoOpt.isEmpty()){
            this.alertaUsuarioErro("Usuário não existente!");
            return false;
        }

        Usuario usuarioBanco = usuarioBancoOpt.get();

        if(usuarioBanco.getUsuario().equals(usuario.getUsuario())){
            if(usuarioBanco.getSenha().equals(usuario.getSenha())){
                return true;
            }else{
                this.alertaUsuarioErro("Senha incorreta!");
                return false;
            }
        }else{
            this.alertaUsuarioErro("Usuário não existente!");
            return false;
        }
    }

    public Boolean verificaUsuarioCadastro(Usuario usuario){
        Optional<Usuario> usuarioBancoOpt = this.buscaUsuarioPorNome(usuario.getUsuario());
        return usuarioBancoOpt.isEmpty();
    }
    
    public String criptografaSenhaUsuario(String senha) {
    	return DigestUtils.sha256Hex(senha);
    }
}
