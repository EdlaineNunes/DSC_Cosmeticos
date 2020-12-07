/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao;

import br.edu.ifnmg.logicaaplicacao.Funcao;
import br.edu.ifnmg.logicaaplicacao.Genero;
import br.edu.ifnmg.logicaaplicacao.PessoaFisica;
import br.edu.ifnmg.logicaaplicacao.PessoaJuridica;
import br.edu.ifnmg.logicaaplicacao.PessoaTipo;
import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Transacao;
import br.edu.ifnmg.logicaaplicacao.TransacaoItem;
import br.edu.ifnmg.logicaaplicacao.TransacaoRepositorio;
import br.edu.ifnmg.logicaaplicacao.TransacaoTipo;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import br.edu.ifnmg.logicaaplicacao.UsuarioRepositorio;
import br.edu.ifnmg.sistemacomercial.persistencia.PessoaFisicaDAO;
import br.edu.ifnmg.sistemacomercial.persistencia.PessoaJuridicaDAO;
import br.edu.ifnmg.sistemacomercial.persistencia.ProdutoDAO;
import br.edu.ifnmg.sistemacomercial.persistencia.TransacaoDAO;
import br.edu.ifnmg.sistemacomercial.persistencia.UsuarioDAO;
import java.math.BigDecimal;

/**
 *
 * @author edlaine
 */
public class Console {

    public static void criarBase(){
       //DAOs
       UsuarioDAO  repoUsuario = new UsuarioDAO();
       PessoaFisicaDAO repoPFisica = new PessoaFisicaDAO();
       PessoaJuridicaDAO repoPJuridica = new PessoaJuridicaDAO();
       ProdutoDAO repoProduto = new ProdutoDAO();
       TransacaoRepositorio repoTransacao = new TransacaoDAO();
       
       //criar usuario do sistema
       Usuario u = new Usuario();
       u.setNome("Maria P");
       u.setFuncao(Funcao.Atendente);
       u.setCpf("11122233344");
       u.setLogin("maria");
       u.setSenha("123");
       u.setSexo(Genero.Feminino);
       repoUsuario.Salvar(u);
       
       Usuario ua = new Usuario();
       ua.setNome("José R");
       ua.setFuncao(Funcao.Caixa);
       ua.setCpf("11122233343");
       ua.setLogin("jose");
       ua.setSenha("123");
       ua.setSexo(Genero.Masculino);
       repoUsuario.Salvar(ua);
       
       Usuario ub = new Usuario();
       ub.setNome("Pablo B");
       ub.setFuncao(Funcao.Gerente);
       ub.setCpf("11122233353");
       ub.setLogin("pablo");
       ub.setSenha("123");
       ub.setSexo(Genero.Outro);
       repoUsuario.Salvar(ub);
       
       //criando pessoaFisica
       PessoaFisica pf = new PessoaFisica();
       pf.setNome("Ana Maria B");
       pf.setGenero(Genero.Feminino);
       pf.setCpf("12345678909");
       pf.setRg("MG0198764");
       pf.setTipo(PessoaTipo.Fisica);
       repoPFisica.Salvar(pf);
       
       PessoaFisica pfA = new PessoaFisica();
       pfA.setNome("João Marcelo B");
       pfA.setGenero(Genero.Masculino);
       pfA.setCpf("12345678900");
       pfA.setRg("MG0198774");
       pfA.setTipo(PessoaTipo.Fisica);
       repoPFisica.Salvar(pfA);
       
       PessoaFisica pfB = new PessoaFisica();
       pfB.setNome("Angelo Junior Pereira");
       pfB.setGenero(Genero.Masculino);
       pfB.setCpf("12345238909");
       pfB.setRg("MG0198784");
       pfB.setTipo(PessoaTipo.Fisica);
       repoPFisica.Salvar(pfB);
       
       
       //criando pessoa juridica
       PessoaJuridica pj = new PessoaJuridica();
       pj.setNome("seu josé barbearia");
       pj.setCnpj("000000000000");
       pj.setRazaoSocial("jose LTDA");
       pj.setNomeFantasia("seu josé barbearia");
       pj.setTipo(PessoaTipo.Jurídica);
       pj.setRua("Rua Oliveira");
       pj.setBairro("Centro");
       pj.setNumero("55A");
       pj.setCidade("Londrina");
       pj.setComplemento("Não há");
       //pj.setRepresentante(repoPFisica.Abrir(1L));
       repoPJuridica.Salvar(pj);
       
       PessoaJuridica pjA = new PessoaJuridica();
       pjA.setNome("Mãos de luxo");
       pjA.setCnpj("0003333000000");
       pjA.setRazaoSocial("Mãos de luxo LTDA");
       pjA.setNomeFantasia("Mãos de Luxo Manicure e Pedicure");
       pjA.setTipo(PessoaTipo.Jurídica);
       pjA.setRua("Rua Almeida");
       pjA.setBairro("São José");
       pjA.setNumero("99");
       pjA.setCidade("Feira de Santana");
       pjA.setComplemento("Não há");
       //pj.setRepresentante(repoPFisica.Abrir(1L));
       repoPJuridica.Salvar(pjA);
       
       //criando produtos
       Produto pdt = new Produto();
       pdt.setNome("Shampoo Seda");
       pdt.setValorUnitario(new BigDecimal("3.5"));
       pdt.setEstoque(30);
       pdt.setUsuario(ua);
       repoProduto.Salvar(pdt);
       
       Produto pdtA = new Produto();
       pdtA.setNome("Condicionar Bio");
       pdtA.setValorUnitario(new BigDecimal("10.0"));
       pdtA.setEstoque(15);
       pdt.setUsuario(u);
       repoProduto.Salvar(pdtA);
       
       Produto pdtB = new Produto();
       pdtB.setNome("Creme de Pentear");
       pdtB.setValorUnitario(new BigDecimal("5.5"));
       pdtB.setEstoque(20);
       pdt.setUsuario(ub);
       repoProduto.Salvar(pdtB);
       
       Produto pdtC = new Produto();
       pdtC.setNome("Creme de pele");
       pdtC.setValorUnitario(new BigDecimal("5.5"));
       pdtC.setEstoque(15);
       pdt.setUsuario(u);
       repoProduto.Salvar(pdtC);
       
       
       //abrir os dados
       //usuario
       var user1 = repoUsuario.Abrir(1L);
       var user2 = repoUsuario.Abrir(2L);
       var user3 = repoUsuario.Abrir(3L);
       
       //pessoaFisica e pessoa Juridica
       var p1 = repoPFisica.Abrir(1L);
       var p2 = repoPFisica.Abrir(2L);
       var p3 = repoPFisica.Abrir(3L);
       
       var pj1 = repoPJuridica.Abrir(4L);
       var pj2 = repoPJuridica.Abrir(5L);
       
       //abrir produto
       var pr1 = repoProduto.Abrir(1L);
       var pr2 = repoProduto.Abrir(2L);
       var pr3 = repoProduto.Abrir(3L);
       var pr4 = repoProduto.Abrir(4L);
       
       
       //criar Transacao
        Transacao t1 = new Transacao(p1,TransacaoTipo.Venda, user1);
        t1.add(new TransacaoItem(pr1, 3));
        t1.add(new TransacaoItem(pr2,4));
        repoTransacao.Salvar(t1);
        
        Transacao t2 = new Transacao(p2,TransacaoTipo.Venda, user2);
        t2.add(new TransacaoItem(pr2, 2));
        t2.add(new TransacaoItem(pr3,4));
        repoTransacao.Salvar(t2);
        
        Transacao t3 = new Transacao(pj1,TransacaoTipo.Compra, user3);
        t3.add(new TransacaoItem(pr1, 15));
        t3.add(new TransacaoItem(pr2,9));
        repoTransacao.Salvar(t3);
        
    }    
    
    
    public static void main(String[] args) {//throws ErroValidacaoException {   
//        //problemas para salvar as transacoes
        criarBase();
//   
//        PessoaFisicaRepositorio repo_pf = new PessoaFisicaDAO();
        
//        PessoaFisica pf = repo_pf.AbrirPorCPF("12345678900");
//        System.out.println(pf.getNome());
//        for(Pessoa pf : repo_pf.Buscar(new PessoaFisica("", null,null,Genero.Feminino)))
//            System.out.println(pf.getNome());
//        UsuarioRepositorio repo =  RepositorioFactory.getUsuarioRepositorio();
//        Usuario u = repo.Abrir(1L);
//        
//        System.out.println(u.getLogin());
        
        
    }
}