/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author edlaine
 */
@Entity
@Table(name="pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER,
        name = "tipo")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (length=250, nullable=false)
    private String nome;
    
    @Enumerated(EnumType.ORDINAL)
    private PessoaTipo tipo;
       
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy= "pessoa")
    private List<PessoaTelefone> telefones;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy= "pessoa")
    private List<PessoaEmail> emails;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Version
    private int version;

    public Pessoa() {
        super();
        this.id = 0L;
        this.nome="";
        this.tipo = null;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.status = Status.Ativo;
        this.version = 1;
    }
    
    public Pessoa(Long id, String nome, PessoaTipo tipo) {
        super();
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.status = Status.Ativo;
        this.version = 1;

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

    public PessoaTipo getTipo() {
        return tipo;
    }

    public void setTipo(PessoaTipo tipo) {
        this.tipo = tipo;
    }

    public List<PessoaTelefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<PessoaTelefone> telefones) {
        this.telefones = telefones;
    }

    public List<PessoaEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<PessoaEmail> emails) {
        this.emails = emails;
    }
    
    public boolean addTelefone(PessoaTelefone telefone){
        if(! this.telefones.contains(telefone)){
            this.telefones.add(telefone);
            return true;
        }
        return false;
    }
    
    public boolean removeTelefone (PessoaTelefone telefone){
        if( this.telefones.contains(telefone)){
            this.telefones.remove(telefone);
            return true;
        }
        return false;
    }
    public boolean addEmail(PessoaEmail email){
        if(! this.emails.contains(email)){
            this.emails.add(email);
            return true;
        }
        return false;
    }
    
    public boolean removeEmail (PessoaEmail email){
        if( this.emails.contains(email)){
            this.emails.remove(email);
            return true;
        }
        return false;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getVersion() {
        return version;
    }

    public void setVersao(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + Objects.hashCode(this.telefones);
        hash = 59 * hash + Objects.hashCode(this.emails);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + this.version;
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
        final Pessoa other = (Pessoa) obj;
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
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
