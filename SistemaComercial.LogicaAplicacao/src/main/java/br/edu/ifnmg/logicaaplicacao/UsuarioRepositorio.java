/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

/**
 *
 * @author edlaine
 */
public interface UsuarioRepositorio 
        extends Repositorio<Usuario>{
    public boolean autenticacao(String login, String senha);
    
    public Usuario nome(String login);
    public boolean apagarUsuario(String login);
}
