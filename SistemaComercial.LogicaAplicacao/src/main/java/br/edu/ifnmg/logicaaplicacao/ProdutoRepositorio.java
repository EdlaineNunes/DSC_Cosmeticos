/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

/**
 *
 * @author edlaine
 */
public interface ProdutoRepositorio extends Repositorio<Produto> {
    public Produto buscaNomeProduto(String nome);
}
