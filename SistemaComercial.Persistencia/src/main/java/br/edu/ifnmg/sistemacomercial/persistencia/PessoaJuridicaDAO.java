/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.persistencia;

import br.edu.ifnmg.logicaaplicacao.PessoaJuridica;
import br.edu.ifnmg.logicaaplicacao.PessoaJuridicaRepositorio;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
