/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.util.List;
import br.edu.ifnmg.logicaaplicacao.UsuarioRepositorio;
import javax.persistence.Query;

/**
 *
 * @author edlaine
 */
public class UsuarioDAO 
        extends DataAcessObject<Usuario> 
        implements UsuarioRepositorio{

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public boolean autenticacao(String login, String senha) {
        Query sql =  this.manager.createQuery("select o from Usuario o where o.login = :login and o.senha = :senha");
        sql.setParameter("login", login);
        sql.setParameter("senha", senha);
        
        if(sql.getResultList().size() > 0)
            return true;
        
        return false;
    }

    @Override
    public List<Usuario> Buscar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
