/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.Status;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.util.List;
import br.edu.ifnmg.logicaaplicacao.UsuarioRepositorio;
import java.util.HashMap;
import javax.persistence.EntityTransaction;
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
        Query sql =  this.manager.createQuery("select o from Usuario o where "
                + "o.login = :login and o.senha = :senha and o.status = :status");
        sql.setParameter("login", login);
        sql.setParameter("senha", senha);
        sql.setParameter("status", Status.Ativo);
        
        if(sql.getResultList().size() > 0)
            return true;
        
        return false;
    }

    @Override
    public List<Usuario> Buscar(Usuario obj) {
        // Consulta JPQL padrão
        String jpql = "select o from Usuario o";
        
        // Dicionário de parâmetros
        HashMap<String, Object> parametros = new HashMap<>();
        
        // Verificação de quais valores existem no objeto
        if(obj != null){
            if(obj.getLogin() != null & !obj.getLogin().isEmpty())
                parametros.put("login", obj.getLogin());
            if(obj.getId() > 0)
                parametros.put("id", obj.getId());
            if(obj.getNome() != null & !obj.getNome().isEmpty())
                parametros.put("nome", obj.getNome());
            if(obj.getCpf()!= null & !obj.getCpf().isEmpty())
                parametros.put("cpf", obj.getCpf());
        }
        
        // Criando toda a parte do JPQL que contém os filtros que criei
        if(!parametros.isEmpty()){
            String filtros = "";
            jpql += " where ";
            for(String campo : parametros.keySet()){
                if(!filtros.isEmpty() && filtros != null)
                    filtros += " and ";
                jpql += "o." + campo + " = :" + campo;
            }
            jpql += filtros;
        }
        
        Query sql = this.manager.createQuery(jpql);
        
        if(!parametros.isEmpty())
            for(String campo : parametros.keySet())
                sql.setParameter(campo, parametros.get(campo));
        return sql.getResultList();
    }

    @Override
    public boolean apagarUsuario(String login) {
        String jpql = "delete from Usuario o where o.login = :login";
        
        EntityTransaction transaction = this.manager.getTransaction();
        try{
            // inicia a transação
            transaction.begin();
            
            Query sql = this.manager.createQuery(jpql);
            sql.setParameter("login", login);

            //Até aqui é simulado a transação e não consecutivamente a transação
            if(sql.executeUpdate() > 0){
                // Aqui é relalizado efetivamente a trasanção/ Finalia a transação
                transaction.commit(); 
                return true;
            }
        }catch(Exception exeption){
            transaction.rollback();
            System.out.println("Exceção: " + exeption);
            return false;
        }
        return false;
    }

    @Override
    public Usuario nome(String login) {
        Query sql =  this.manager.createQuery("select o from Usuario o where "
                + "o.login = :login");
        sql.setParameter("login", login);
        
        return (Usuario)sql.getSingleResult();
        
    }
    
}
