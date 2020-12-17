/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.Transacao;
import java.util.List;
import br.edu.ifnmg.logicaaplicacao.TransacaoRepositorio;
import java.util.Hashtable;
import javax.persistence.Query;

/**
 *
 * @author edlaine
 */
public class TransacaoDAO 
        extends DataAcessObject<Transacao> 
        implements TransacaoRepositorio {

    public TransacaoDAO() {
        super(Transacao.class);
    }

    @Override
    public List<Transacao> Buscar(Transacao obj) {
        String jpql = "select t from Transacao t";
        String filtros = "";
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
        
            if(obj.getId() > 0){
                filtros += "t.id = :id";
                parametros.put("id", obj.getId());
            } 
//            if(obj.getPessoa() != null && obj.getPessoa().getId() > 0){
//                if(filtros.length() > 0) filtros += " and ";
//                filtros += "t.pessoa_id like :pessoa";
//                parametros.put("pessoa_id", obj.getPessoa().getId());
//            }
            if(obj.getUsuario() != null && obj.getUsuario().getId() > 0){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "t.usuario_id = :usuario";
                parametros.put("usuario_id", obj.getUsuario().getId());
            } 
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " where " + filtros;
        
        Query consulta = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet())
            consulta.setParameter(chave, parametros.get(chave));
        
        return consulta.getResultList(); 
    }
    
}
