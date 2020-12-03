/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author edlaine
 */
@Entity
@Table (name="transacoes")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //1 pessoa N transacoes
    @ManyToOne( cascade = CascadeType.MERGE, fetch= FetchType.EAGER)
    @JoinColumn(name="pessoa_id", nullable=false)
    private Pessoa pessoa;
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date criacao;

    @Column(precision=8, scale=2)
    public BigDecimal valorTotal;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy= "transacao")
    private List<TransacaoItem> itens;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable=false)
    private TransacaoTipo tipo;
    
    //controle de concorrencia
    @Version
    private int version;

    public Transacao() {
        this.id=0L;
        this.pessoa= null;
        this.valorTotal = new BigDecimal("0.0");
        this.criacao = new Date();
        this.itens = new ArrayList<>();
        this.tipo= TransacaoTipo.Venda;
    }

    public Transacao(Long id, Pessoa pessoa, Date criacao, 
            BigDecimal valorTotal, TransacaoTipo tipo) {
        this.id = id;
        this.pessoa = new Pessoa();
        this.criacao = new Date();
        this.valorTotal = new BigDecimal("valorTotal");
        this.tipo = tipo; 
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<TransacaoItem> getItens() {
        return itens;
    }

    public void setItens(List<TransacaoItem> itens) {
        this.itens = itens;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    public boolean add(TransacaoItem item){
        if(! this.itens.contains(item)){
            this.itens.add(item);
            this.valorTotal = this.valorTotal.add (
            item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
            return true;
        }
        return false;
    }
    
    public boolean remove (TransacaoItem item){
        if( this.itens.contains(item)){
            this.itens.remove(item);
            this.valorTotal = this.valorTotal.subtract (
            item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
            return true;
        }
        return false;
    }

    public TransacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(TransacaoTipo tipo) {
        this.tipo = tipo;
    }
           
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.pessoa);
        hash = 97 * hash + Objects.hashCode(this.criacao);
        hash = 97 * hash + Objects.hashCode(this.valorTotal);
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
        final Transacao other = (Transacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.criacao, other.criacao)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.id.toString();
    }
    
}
