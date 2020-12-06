/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    public Produto() {
        super();
        this.id=0L;
        this.nome="";
        this.valorUnitario= new BigDecimal("0.0");
        this.version = 1;
        this.estoque = 0;
    }

    public Produto(String nome, String valorUnitario,
            int estoque) {
        super();
        this.id = 0L;
        this.nome = nome;
        this.valorUnitario = new BigDecimal(valorUnitario);
        this.version = 1;
        this.estoque = estoque;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.valorUnitario);
        hash = 59 * hash + this.estoque;
        hash = 59 * hash + this.version;
        hash = 59 * hash + Objects.hashCode(this.usuario);
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
        return true;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
    
}
