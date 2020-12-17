package br.edu.ifnmg.logicaaplicacao;

import br.edu.ifnmg.logicaaplicacao.ProdutoAplicacao;
import br.edu.ifnmg.logicaaplicacao.ProdutoFinalidade;
import br.edu.ifnmg.logicaaplicacao.Status;
import br.edu.ifnmg.logicaaplicacao.UnidadeCompra;
import br.edu.ifnmg.logicaaplicacao.UnidadeVenda;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T17:22:10")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, UnidadeVenda> unidvenda;
    public static volatile SingularAttribute<Produto, Integer> razaovenda;
    public static volatile SingularAttribute<Produto, ProdutoFinalidade> finalidade;
    public static volatile SingularAttribute<Produto, ProdutoAplicacao> aplicacao;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> version;
    public static volatile SingularAttribute<Produto, BigDecimal> valorUnitario;
    public static volatile SingularAttribute<Produto, UnidadeCompra> unidcompra;
    public static volatile SingularAttribute<Produto, Integer> estoque;
    public static volatile SingularAttribute<Produto, Usuario> usuario;
    public static volatile SingularAttribute<Produto, Integer> razaocompra;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, Status> status;

}