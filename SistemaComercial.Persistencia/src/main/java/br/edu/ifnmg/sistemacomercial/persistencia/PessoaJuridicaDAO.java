/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.PessoaFisica;
import br.edu.ifnmg.logicaaplicacao.PessoaJuridica;
import br.edu.ifnmg.logicaaplicacao.PessoaJuridicaRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author edlaine
 */
public class PessoaJuridicaDAO 
        extends DataAcessObject<PessoaJuridica> 
        implements PessoaJuridicaRepositorio{

    public PessoaJuridicaDAO() {
        super(PessoaJuridica.class);
    }

    @Override
    public List<PessoaJuridica> Buscar(PessoaJuridica obj) {
        String jpql = "select pj from PessoaJuridica pj";
        String filtros = "";
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
        
            if(obj.getNome().length() > 0){
                filtros += "pj.nome like :nome";
                parametros.put("nome", obj.getNome() + "%");
            }

            if(obj.getRazaoSocial() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.razaoSocial = :razaoSocial";
                parametros.put("razaoSocial", obj.getRazaoSocial());
            }

            if(obj.getCnpj()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.cnpj like :cnpj";
                parametros.put("cnpj", obj.getCnpj() + "%");
            }
            if(obj.getRua()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.rua like :rua";
                parametros.put("rua", obj.getRua() + "%");
            }
            if(obj.getNumero()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.numero like :numero";
                parametros.put("numero", obj.getNumero() + "%");
            }
            if(obj.getBairro()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.bairro like :bairro";
                parametros.put("bairro", obj.getBairro() + "%");
            }
            if(obj.getComplemento()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.complemento like :complemento";
                parametros.put("complemento", obj.getComplemento() + "%");
            }
            if(obj.getCidade()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pj.cidade like :cidade";
                parametros.put("cidade", obj.getCidade() + "%");
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
    public PessoaJuridica AbrirPorCNPJ(String cnpj) {
        Query consulta = this.manager.createQuery("select pj from PessoaJuridica pj where pj.cnpj =:parametro");
        consulta.setParameter("parametro", cnpj);
        return (PessoaJuridica)consulta.getSingleResult();    
    }

}
