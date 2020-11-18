/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial_persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import br.edu.ifnmg.logicaaplicacao.Repositorio;

/**
 *
 * @author edlaine
 */
public abstract class  DataAcessObject<T> implements Repositorio<T>{

    private EntityManager manager; 
    private Class type; 
    
    public DataAcessObject(Class type){
        var factory = Persistence.createEntityManagerFactory("PU");
        this.manager = factory.createEntityManager();
        this.type = type;    
    }
    
    @Override
    public boolean Salvar(T obj) {
        EntityTransaction transacao = this.manager.getTransaction();
        
        try{
            //inicio da transacao
            transacao.begin();
            
            //persistir transacao no bd
            this.manager.persist(obj);
            
            //confirmar transacao
            transacao.commit();
            System.out.println("Commit");
            
            return true;      
        
        }catch(Exception ex){
            //cancelar transacao
            transacao.rollback();
            System.out.println("Message: "+ ex);
            
            return false;
        }
        
    }

    @Override
    public boolean Apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Abrir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public abstract List<T> Buscar(T obj);
    
}
