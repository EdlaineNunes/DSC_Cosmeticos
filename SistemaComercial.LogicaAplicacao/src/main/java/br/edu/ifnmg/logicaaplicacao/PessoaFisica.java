/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author edlaine
 */
@Entity
@Table(name="pessoasFisicas")
@DiscriminatorValue(value = "1")
public class PessoaFisica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Column (length = 20, nullable= false, unique=true)
    private String cpf;
    
    @Column (length = 20, nullable = true)
    private String rg;
    
    @Version
    private int versao;
    
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public PessoaFisica() {
        super();
        this.setTipo(PessoaTipo.Fisica);
        this.cpf= "";
        this.rg = "";
        this.genero = Genero.Feminino;
        this.versao = 1;
    }

    public PessoaFisica(String nome,String cpf, String rg, Genero genero) {
        super();
        this.setTipo(PessoaTipo.Fisica);
        this.setNome(nome);
        this.cpf = cpf;
        this.rg = rg;
        this.versao = 1;
        this.genero = genero;
    } 

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cpf);
        hash = 53 * hash + Objects.hashCode(this.rg);
        hash = 53 * hash + Objects.hashCode(this.genero);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (this.genero != other.genero) {
            return false;
        }
        return true;
    }  
    
    @Override
    public String toString() {
        return this.cpf;
    }
    
}
