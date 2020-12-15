/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author edlaine
 */

@Entity
@Table(name="produtos")
@SecondaryTable(name = "estoque")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length=250, nullable=false, unique=true)
    private String nome;
    
    @Column(precision=8, scale=2)
    private BigDecimal valorUnitario;
    
    @Column(nullable = false, table= "estoque")
    private int estoque;
    
    //controle de concorrencia
    @Version
    private int version;
    
    @ManyToOne
    private Usuario usuario;
    
    @Enumerated(EnumType.STRING)
    private UnidadeCompra unidcompra;
    
    @Enumerated(EnumType.STRING)
    private UnidadeVenda unidvenda;
    
    @Column 
    private int razaocompra;
    
    @Column 
    private int razaovenda;
    
    @Enumerated(EnumType.STRING)
    private ProdutoFinalidade finalidade;
     
    @Enumerated(EnumType.STRING)
    private ProdutoAplicacao aplicacao;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    

    public Produto() {
        super();
        this.id=0L;
        this.nome="";
        this.valorUnitario= new BigDecimal("0.0");
        this.version = 1;
        this.estoque = 0;
        this.unidcompra = UnidadeCompra.Caixa;
        this.razaocompra = 0;
        this.unidvenda = UnidadeVenda.Unidade;
        this.razaovenda = 0;
        this.finalidade = ProdutoFinalidade.Perfumar;
        this.aplicacao = ProdutoAplicacao.Pele;
        this.status = Status.Ativo;
        this.usuario = usuario;
    }

    public Produto(String nome, String valorUnitario,
            int estoque) {
        super();
        this.id = 0L;
        this.nome = nome;
        this.valorUnitario = new BigDecimal(valorUnitario);
        this.version = 1;
        this.estoque = estoque;
        this.unidcompra = UnidadeCompra.Caixa;
        this.razaocompra = razaocompra;
        this.unidvenda = UnidadeVenda.Unidade;
        this.razaovenda = razaovenda;
        this.finalidade = ProdutoFinalidade.Perfumar;
        this.aplicacao = ProdutoAplicacao.Pele;
        this.status = Status.Ativo;
        this.usuario = usuario;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UnidadeCompra getUnidcompra() {
        return unidcompra;
    }

    public void setUnidcompra(UnidadeCompra unidcompra) {
        this.unidcompra = unidcompra;
    }

    public UnidadeVenda getUnidvenda() {
        return unidvenda;
    }

    public void setUnidvenda(UnidadeVenda unidvenda) {
        this.unidvenda = unidvenda;
    }

    public int getRazaocompra() {
        return razaocompra;
    }

    public void setRazaocompra(int razaocompra) {
        this.razaocompra = razaocompra;
    }

    public int getRazaovenda() {
        return razaovenda;
    }

    public void setRazaovenda(int razaovenda) {
        this.razaovenda = razaovenda;
    }

    public ProdutoFinalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(ProdutoFinalidade finalidade) {
        this.finalidade = finalidade;
    }

    public ProdutoAplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(ProdutoAplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.valorUnitario);
        hash = 59 * hash + this.estoque;
        hash = 59 * hash + this.version;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.unidcompra);
        hash = 59 * hash + Objects.hashCode(this.unidvenda);
        hash = 59 * hash + this.razaocompra;
        hash = 59 * hash + this.razaovenda;
        hash = 59 * hash + Objects.hashCode(this.finalidade);
        hash = 59 * hash + Objects.hashCode(this.aplicacao);
        hash = 59 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.estoque != other.estoque) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (this.razaocompra != other.razaocompra) {
            return false;
        }
        if (this.razaovenda != other.razaovenda) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.valorUnitario, other.valorUnitario)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (this.unidcompra != other.unidcompra) {
            return false;
        }
        if (this.unidvenda != other.unidvenda) {
            return false;
        }
        if (this.finalidade != other.finalidade) {
            return false;
        }
        if (this.aplicacao != other.aplicacao) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
