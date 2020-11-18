/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial_apresentacao;

import br.edu.ifnmg.logicaaplicacao.Cliente;
import br.edu.ifnmg.logicaaplicacao.ClienteRepositorio;
import br.edu.ifnmg.logicaaplicacao.Sexo;
import br.edu.ifnmg.sistemacomercial_persistencia.ClienteDAO;

/**
 *
 * @author edlaine
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ClienteRepositorio repo = new ClienteDAO();
        Cliente c = new Cliente();
        c.setNome("ana");
        
        if(repo.Salvar(c)){
            System.out.println("Sucesso!");
        }
        else{
            System.out.println("Falha!");
        }
    }
    
}
