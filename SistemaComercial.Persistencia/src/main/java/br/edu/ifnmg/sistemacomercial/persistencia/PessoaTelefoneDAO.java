/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.PessoaTelefone;
import br.edu.ifnmg.logicaaplicacao.PessoaTelefoneRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author edlaine
 */
public class PessoaTelefoneDAO 
        extends DataAcessObject<PessoaTelefone> 
        implements PessoaTelefoneRepositorio {

    public PessoaTelefoneDAO() {
        super(PessoaTelefone.class);
    }

    @Override
    public List<PessoaTelefone> Buscar(PessoaTelefone obj) {
        String jpql = "select t from PessoaTelefone t";
        String filtros = "";
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
        
            if(obj.getTelefone().length() > 0){
                filtros += "t.telefone like :telefone";
                parametros.put("telefone", obj.getTelefone() + "%");
            } 
            if(obj.getId() > 0){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "t.id = :id";
                parametros.put("id", obj.getId());
            } 
            if(obj.getPessoa() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "t.pessoa = :pessoa";
                parametros.put("pessoa", obj.getPessoa());
            } 
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " where " + filtros;
        
        Query consulta = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet())
            consulta.setParameter(chave, parametros.get(chave));
        
        return consulta.getResultList();    }

}
