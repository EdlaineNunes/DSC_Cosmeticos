/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;


import br.edu.ifnmg.logicaaplicacao.PessoaFisica;
import br.edu.ifnmg.logicaaplicacao.PessoaFisicaRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author edlaine
 */
public class PessoaFisicaDAO
        extends DataAcessObject<PessoaFisica> 
        implements PessoaFisicaRepositorio {

    public PessoaFisicaDAO() {
        super(PessoaFisica.class);
    }

    @Override
    public List<PessoaFisica> Buscar(PessoaFisica obj) {
//        Query consulta = this.manager.createQuery("select pf from PessoaFisica");
//        return consulta.getResultList();
        
        String jpql = "select pf from PessoaFisica pf";
        String filtros = "";
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
        
            if(obj.getNome().length() > 0){
                filtros += "pf.nome like :nome";
                parametros.put("nome", obj.getNome() + "%");
            }
            
            if(obj.getId() > 0){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pf.id = :id";
                parametros.put("id", obj.getId());
            }
            
            if(obj.getGenero() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pf.genero = :genero";
                parametros.put("genero", obj.getGenero());
            }
            
            if(obj.getTipo().toString() == "Física"){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pf.tipo = :tipo";
                parametros.put("tipo", obj.getTipo());
            }
            
            if(obj.getRg()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pf.rg like :rg";
                parametros.put("rg", obj.getRg() + "%");
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
    public PessoaFisica AbrirPorCPF(String cpf) {
        Query consulta = this.manager.createQuery("select pf from PessoaFisica pf where pf.cpf =:parametro");
        consulta.setParameter("parametro", cpf);
        return (PessoaFisica)consulta.getSingleResult();
    }
    
}
