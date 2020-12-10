/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.Pessoa;
import br.edu.ifnmg.logicaaplicacao.PessoaRepositorio;
import br.edu.ifnmg.logicaaplicacao.PessoaTipo;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

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

            if(obj.getTipo() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "p.tipo = :tipo";
                parametros.put("tipo", obj.getTipo());
            } 
            if(obj.getId() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "p.id = :id";
                parametros.put("id", obj.getId());
            } 
            if(obj.getTelefones() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "p.telefones = :telefones";
                parametros.put("telefones", obj.getTelefones());
            } 
            if(obj.getEmails() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "p.emails = :emails";
                parametros.put("emails", obj.getEmails());
            } 
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " where " + filtros;
        
        Query consulta = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet())
            consulta.setParameter(chave, parametros.get(chave));
        
        return consulta.getResultList();    }

    @Override
    public Pessoa AbrirPorTipo(PessoaTipo tipo) {
        Query consulta = this.manager.createQuery("select p from Pessoa p where p.tipo =:parametro");
        consulta.setParameter("parametro", tipo);
        return (Pessoa)consulta.getSingleResult();      }
    
}
