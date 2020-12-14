/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

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

    protected EntityManager manager; 
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
        EntityTransaction transacao = this.manager.getTransaction();
        try{
            //inicio da transacao
            transacao.begin();
            
            //torna o obj gerenciavel
            this.manager.merge(obj);
            //remover transacao no bd
            this.manager.remove(obj);
            
            //confirmar remoção
            transacao.commit();
            
            return true;      
        
        }catch(Exception ex){
            //cancelar transacao
            transacao.rollback();
            System.out.println("Message: "+ ex);
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {        
        try{            
            T obj = (T)this.manager.find(this.type,id);
            return obj;
        }catch(Exception ex){
            //System.out.println("Message: "+ ex);
            return null;
        }
    }

    public abstract List<T> Buscar(T obj);
    
}
