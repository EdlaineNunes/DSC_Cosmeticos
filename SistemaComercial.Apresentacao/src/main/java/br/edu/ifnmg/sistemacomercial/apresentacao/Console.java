/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao;

import br.edu.ifnmg.logicaaplicacao.ErroValidacaoException;
import br.edu.ifnmg.logicaaplicacao.Funcao;
import br.edu.ifnmg.logicaaplicacao.Genero;
import br.edu.ifnmg.logicaaplicacao.PessoaEmail;
import br.edu.ifnmg.logicaaplicacao.PessoaFisica;
import br.edu.ifnmg.logicaaplicacao.PessoaFisicaRepositorio;
import br.edu.ifnmg.logicaaplicacao.PessoaJuridica;
import br.edu.ifnmg.logicaaplicacao.PessoaTelefone;
import br.edu.ifnmg.logicaaplicacao.PessoaTipo;
import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.ProdutoAplicacao;
import br.edu.ifnmg.logicaaplicacao.ProdutoFinalidade;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Status;
import br.edu.ifnmg.logicaaplicacao.Transacao;
import br.edu.ifnmg.logicaaplicacao.TransacaoItem;
import br.edu.ifnmg.logicaaplicacao.TransacaoRepositorio;
import br.edu.ifnmg.logicaaplicacao.TransacaoTipo;
import br.edu.ifnmg.logicaaplicacao.UnidadeCompra;
import br.edu.ifnmg.logicaaplicacao.UnidadeVenda;
import br.edu.ifnmg.logicaaplicacao.Usuario;
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

    public static void criarBase() throws ErroValidacaoException{
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
       u.setCpf("11111111111");
       u.setLogin("maria");
       u.setSenha("123");
       u.setSexo(Genero.Feminino);
       u.setStatus(Status.Ativo);
       repoUsuario.Salvar(u);
       
       Usuario ua = new Usuario();
       ua.setNome("José R");
       ua.setFuncao(Funcao.Caixa);
       ua.setCpf("22222222222");
       ua.setLogin("jose");
       ua.setSenha("123");
       ua.setSexo(Genero.Masculino);
       ua.setStatus(Status.Ativo);
       repoUsuario.Salvar(ua);
       
       Usuario ub = new Usuario();
       ub.setNome("Pablo B");
       ub.setFuncao(Funcao.Gerente);
       ub.setCpf("33333333333");
       ub.setLogin("pablo");
       ub.setSenha("123");
       ub.setSexo(Genero.Outro);
       ub.setStatus(Status.Ativo);
       repoUsuario.Salvar(ub);
       
       Usuario uc = new Usuario();
       uc.setNome("Administrador");
       uc.setFuncao(Funcao.Gerente);
       uc.setCpf("33334433333");
       uc.setLogin("adm");
       uc.setSenha("123");
       uc.setSexo(Genero.Outro);
       uc.setStatus(Status.Ativo);
       repoUsuario.Salvar(uc);
       
       //criando pessoaFisica
       PessoaFisica pf = new PessoaFisica();
       pf.setNome("Ana Maria B");
       pf.setGenero(Genero.Feminino);
       pf.setCpf("44444444444");
       pf.setRg("MG0198764");
       pf.setTipo(PessoaTipo.Fisica);
       pf.addTelefone(new PessoaTelefone(pf, "111111111"));
       pf.addEmail(new PessoaEmail(pf, "email@gmail.com"));
       pf.addTelefone(new PessoaTelefone(pf, "222222222"));
       pf.addEmail(new PessoaEmail(pf, "teste@gmail.com"));
       pf.setStatus(Status.Ativo);
       repoPFisica.Salvar(pf);
       
       PessoaFisica pfA = new PessoaFisica();
       pfA.setNome("João Marcelo B");
       pfA.setGenero(Genero.Masculino);
       pfA.setCpf("55555555555");
       pfA.setRg("MG0198774");
       pfA.setTipo(PessoaTipo.Fisica);
       pfA.addTelefone(new PessoaTelefone(pfA, "111111122"));
       pfA.addEmail(new PessoaEmail(pfA, "email@gmail.com"));
       pfA.setStatus(Status.Ativo);
       repoPFisica.Salvar(pfA);
       
       PessoaFisica pfB = new PessoaFisica();
       pfB.setNome("Angelo Junior Pereira");
       pfB.setGenero(Genero.Masculino);
       pfB.setCpf("77777777777");
       pfB.setRg("MG0198784");
       pfB.setTipo(PessoaTipo.Fisica);
       pfB.addTelefone(new PessoaTelefone(pfB, "111111133"));
       pfB.addEmail(new PessoaEmail(pfB, "email@gmail.com"));
       pfB.setStatus(Status.Ativo);
       repoPFisica.Salvar(pfB);
       
       
       //criando pessoa juridica
       PessoaJuridica pj = new PessoaJuridica();
       pj.setNome("seu josé barbearia");
       pj.setCnpj("000000000000");
       pj.setRazaoSocial("jose LTDA");
       pj.setTipo(PessoaTipo.Juridica);
       pj.setRua("Rua Oliveira");
       pj.setBairro("Centro");
       pj.setNumero("55A");
       pj.setCidade("Londrina");
       pj.setComplemento("Não há");
       pj.addTelefone(new PessoaTelefone(pj, "111111441"));
       pj.addEmail(new PessoaEmail(pj, "email@gmail.com"));
       pj.setStatus(Status.Ativo);
       repoPJuridica.Salvar(pj);
       
       PessoaJuridica pjA = new PessoaJuridica();
       pjA.setNome("Mãos de luxo");
       pjA.setCnpj("0003333000000");
       pjA.setRazaoSocial("Mãos de luxo LTDA");
       pjA.setTipo(PessoaTipo.Juridica);
       pjA.setRua("Rua Almeida");
       pjA.setBairro("São José");
       pjA.setNumero("99");
       pjA.setCidade("Feira de Santana");
       pjA.setComplemento("Não há");
       pjA.addTelefone(new PessoaTelefone(pjA, "111111551"));
       pjA.addEmail(new PessoaEmail(pjA, "email@gmail.com"));  
       pjA.setStatus(Status.Ativo);
       repoPJuridica.Salvar(pjA);
       
       //criando produtos
       Produto pdt = new Produto();
       pdt.setNome("Shampoo Seda");
       pdt.setValorUnitario(new BigDecimal("3.5"));
       pdt.setUsuario(ua);
       pdt.setFinalidade(ProdutoFinalidade.Limpar);
       pdt.setAplicacao(ProdutoAplicacao.Capilar);
       pdt.setUnidcompra(UnidadeCompra.Caixa);
       pdt.setRazaocompra(15);
       pdt.setUnidvenda(UnidadeVenda.Unidade);
       pdt.setRazaovenda(1);
       pdt.setStatus(Status.Ativo);
       repoProduto.Salvar(pdt);
       
       Produto pdtA = new Produto();
       pdtA.setNome("Condicionar Bio");
       pdtA.setValorUnitario(new BigDecimal("10.0"));
       pdtA.setUsuario(u);
       pdtA.setFinalidade(ProdutoFinalidade.Limpar);
       pdtA.setAplicacao(ProdutoAplicacao.Capilar);
       pdtA.setUnidcompra(UnidadeCompra.Caixa);
       pdtA.setRazaocompra(20);
       pdtA.setUnidvenda(UnidadeVenda.Unidade);
       pdtA.setRazaovenda(1);
       pdtA.setStatus(Status.Ativo);
       repoProduto.Salvar(pdtA);
       
       Produto pdtB = new Produto();
       pdtB.setNome("Creme de Pentear");
       pdtB.setValorUnitario(new BigDecimal("5.5"));
       pdtB.setUsuario(ub);
       pdtB.setFinalidade(ProdutoFinalidade.Limpar);
       pdtB.setAplicacao(ProdutoAplicacao.Capilar);
       pdtB.setUnidcompra(UnidadeCompra.Caixa);
       pdtB.setRazaocompra(30);
       pdtB.setUnidvenda(UnidadeVenda.Unidade);
       pdtB.setStatus(Status.Ativo);
       pdtB.setRazaovenda(1);
       repoProduto.Salvar(pdtB);
       
       Produto pdtC = new Produto();
       pdtC.setNome("Creme de pele");
       pdtC.setValorUnitario(new BigDecimal("5.5"));
       pdtC.setUsuario(u);
       pdtC.setFinalidade(ProdutoFinalidade.Perfumar);
       pdtC.setAplicacao(ProdutoAplicacao.Pele);
       pdtC.setUnidcompra(UnidadeCompra.Caixa);
       pdtC.setRazaocompra(15);
       pdtC.setUnidvenda(UnidadeVenda.Unidade);
       pdtC.setRazaovenda(1);
       pdtC.setStatus(Status.Ativo);
       repoProduto.Salvar(pdtC);
       
       
       //abrir os dados
       //usuario
       var user1 = repoUsuario.Abrir(1L);
       var user2 = repoUsuario.Abrir(2L);
       var user3 = repoUsuario.Abrir(3L);
       var user4 = repoUsuario.Abrir(4L);
       
       //pessoaFisica e pessoa Juridica
       var p1 = repoPFisica.Abrir(5L);
       var p2 = repoPFisica.Abrir(6L);
       var p3 = repoPFisica.Abrir(7L);
       
       var pj1 = repoPJuridica.Abrir(8L);       
       var pj2 = repoPJuridica.Abrir(9L);
       
       //abrir produto
       var pr1 = repoProduto.Abrir(10L);
       var pr2 = repoProduto.Abrir(11L);
       var pr3 = repoProduto.Abrir(12L);
       var pr4 = repoProduto.Abrir(13L);
       
       
       //criar Transacao
       Transacao t3 = new Transacao(pj1,TransacaoTipo.Compra, user3);
       t3.add(new TransacaoItem(t3,pr1,15));
       t3.add(new TransacaoItem(t3,pr2,90));
       t3.add(new TransacaoItem(t3,pr3,90));
       t3.add(new TransacaoItem(t3,pr4,90));
       t3.add(new TransacaoItem(t3,pr1,90));
       t3.add(new TransacaoItem(t3,pr2,90));
       
       pr1.setEstoque(15, TransacaoTipo.Compra );
       repoProduto.Salvar(pr1);
       
       pr2.setEstoque(90, TransacaoTipo.Compra);
       repoProduto.Salvar(pr2);
       
       pr3.setEstoque(90, TransacaoTipo.Compra);
       repoProduto.Salvar(pr3);
       
       pr4.setEstoque(90, TransacaoTipo.Compra);
       repoProduto.Salvar(pr4);
       
       pr1.setEstoque(90, TransacaoTipo.Compra);
       repoProduto.Salvar(pr1);
       
       pr2.setEstoque(90, TransacaoTipo.Compra);
       repoProduto.Salvar(pr2);
       
       repoTransacao.Salvar(t3);

       
       Transacao t1 = new Transacao(p1,TransacaoTipo.Venda, user1);
       t1.add(new TransacaoItem(t1,pr1,3));
       t1.add(new TransacaoItem(t1,pr2,4));
       
       pr1.setEstoque(3, TransacaoTipo.Venda);
       repoProduto.Salvar(pr1);
       
       pr2.setEstoque(4, TransacaoTipo.Venda);
       repoProduto.Salvar(pr2);
       repoTransacao.Salvar(t1);
        
       
       Transacao t2 = new Transacao(p2,TransacaoTipo.Venda, user2);
       t2.add(new TransacaoItem(t2,pr2,2));
       t2.add(new TransacaoItem(t2,pr3,4));
       
       pr2.setEstoque(2, TransacaoTipo.Venda);
       repoProduto.Salvar(pr2);
       
       pr3.setEstoque(4, TransacaoTipo.Venda);
       repoProduto.Salvar(pr3);
       repoTransacao.Salvar(t2);
        
    }    
    
    
    public static void main(String[] args) throws ErroValidacaoException {//throws ErroValidacaoException {   

        criarBase();
//        PessoaFisicaRepositorio repo = RepositorioFactory.getPessoaFisicaRepositorio();
//        PessoaFisica p = repo.Abrir(11L);
//        
//        if(repo.Apagar(p))
//            System.out.println("SUCESSO");
//        else
//            System.out.println("Erro");
//        
//        PessoaRepositorio repo = RepositorioFactory.getPessoaRepositorio();
//        
//        Pessoa p = repo.Abrir(7L);
//        if(repo.Apagar(p))
//            System.out.println("SUCESSO");
//        else
//            System.out.println("ERRO");
        
//        UsuarioRepositorio repo = RepositorioFactory.getUsuarioRepositorio();
//        
//        //Usuario u = repo.Abrir(51L);
//        Usuario u = repo.Abrir(251L);
//        String pesq = u.getLogin();
//        System.out.println(pesq);
//        if (repo.apagarUsuario(pesq))
//            System.out.println("SUCESSO");
//        else
//            System.out.println("ERRO");

        
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