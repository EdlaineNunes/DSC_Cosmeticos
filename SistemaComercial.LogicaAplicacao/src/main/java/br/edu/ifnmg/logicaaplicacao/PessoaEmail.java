/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author edlaine
 */
@Entity
@Table (name = "emails")
public class PessoaEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //chave estrangeira que tb é primária
    @Id
    //relacionamento
    @ManyToOne
    //especificações da tabela
    @JoinColumn(name="pessoas_id", nullable=false)
    private Pessoa pessoa;
        
    private String email;

    public PessoaEmail() {
        this.id = 0L;
        this.pessoa = null;
        this.email = "";
    }

    public PessoaEmail(Pessoa pessoa, String email) {
        this.id = 0L;
        this.pessoa = pessoa;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.pessoa);
        hash = 41 * hash + Objects.hashCode(this.email);
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
        final PessoaEmail other = (PessoaEmail) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return pessoa.getNome();
    }
}
