/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial_persistencia;

import br.edu.ifnmg.logicaaplicacao.Cliente;
import br.edu.ifnmg.logicaaplicacao.ClienteRepositorio;
import java.util.List;

/**
 *
 * @author edlaine
 */
public class ClienteDAO 
        extends DataAcessObject<Cliente> 
        implements ClienteRepositorio{

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> Buscar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
