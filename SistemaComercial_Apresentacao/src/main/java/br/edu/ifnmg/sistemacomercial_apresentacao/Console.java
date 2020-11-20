/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial_apresentacao;

import br.edu.ifnmg.logicaaplicacao.ErroValidacaoException;
import br.edu.ifnmg.logicaaplicacao.Sexo;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import br.edu.ifnmg.logicaaplicacao.UsuarioRepositorio;
import br.edu.ifnmg.sistemacomercial_persistencia.UsuarioDAO;

/**
 *
 * @author edlaine
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//throws ErroValidacaoException {
        // TODO code application logic here
        
//        ClienteRepositorio repo = new ClienteDAO();
//        Cliente c = new Cliente();
//        c.setNome("ana");
//        
//        if(repo.Salvar(c)){
//            System.out.println("Sucesso!");
//        }
//        else{
//            System.out.println("Falha!");
//        }

          UsuarioRepositorio repo = new UsuarioDAO();
//          Usuario u = new Usuario();
//          u.setLogin("jose");
//          u.setSenha("123");
//          u.setNome("jose");
//          u.setSexo(Sexo.M);   //não tá salvando sexo prq é enumeracao
//          u.setCpf("11111111111");
//          
//          if(repo.Salvar(u))
//              System.out.println("Salvo com sucesso");
//          else
//              System.out.println("Falha ao salvar");
        Usuario u = repo.Abrir(1L);
        System.out.println(u.getLogin());
          
    }
    
}
