/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.ProdutoRepositorio;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author edlaine
 */
public class ProdutoDAO 
    extends DataAcessObject<Produto> 
        implements ProdutoRepositorio{

    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> Buscar(Produto obj) {
        String jpql = "select p from Produto p";
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
    public Produto buscaNomeProduto(String nome) {
        String jpql = "select p from Produto p where p.nome =:nome";
        Query consulta = this.manager.createQuery(jpql);
        consulta.setParameter("nome", nome);
        
        if(consulta.getResultList().size() > 0)
            return (Produto) consulta.getSingleResult();
        return null;
    }
    
}
