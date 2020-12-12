/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.Pessoa;
import br.edu.ifnmg.logicaaplicacao.PessoaTipo;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;
import br.edu.ifnmg.logicaaplicacao.PessoaRepositorio;

/**
 *
 * @author edlaine
 */
public class PessoaDAO 
        extends DataAcessObject<Pessoa> 
        implements PessoaRepositorio{

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> Buscar(Pessoa obj) {
        String jpql = "select p from Pessoa p";
        String filtros = "";
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
        
            if(obj.getNome().length() > 0){
                filtros += "p.nome like :nome";
                parametros.put("nome", obj.getNome() + "%");
            } 
            if(obj.getId() > 0){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "p.id = :id";
                parametros.put("id", obj.getId());
            } 
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " where " + filtros;
        
        Query consulta = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet())
            consulta.setParameter(chave, parametros.get(chave));
        
        return consulta.getResultList();   
    }

    @Override
    public Pessoa AbrirPorTipo(PessoaTipo tipo) {
        Query consulta = this.manager.createQuery("select p from Pessoa p where p.tipo =:parametro");
        consulta.setParameter("parametro", tipo);
        return (Pessoa)consulta.getSingleResult();    
    }

    
//    public List<Pessoa> AbrirTodos(Pessoa obj, PessoaTipo tipo) {
//        String jpql = "select p from Pessoa p where p.tipo =:parametro";
//        String filtros = "";
//        Hashtable<String, Object> parametros = new Hashtable<>();
//        parametros.put("parametro", tipo);
//        
//        if(obj != null){
//        
//            if(obj.getNome().length() > 0){
//                filtros += " and ";
//                filtros += "p.nome like :nome";
//                parametros.put("nome", obj.getNome() + "%");
//            } 
//            if(obj.getId() > 0){
//                filtros += " and ";
//                filtros += "p.id = :id";
//                parametros.put("id", obj.getId());
//            } 
//        }
//        
//        if(filtros.length() > 0)
//            jpql = jpql + filtros;
//        
//        Query consulta = this.manager.createQuery(jpql);
//        
//        for(String chave : parametros.keySet())
//            consulta.setParameter(chave, parametros.get(chave));
//        
//        return consulta.getResultList();
//    }

    @Override
    public List<Pessoa> AbrirTodos(Pessoa obj, PessoaTipo tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
}
