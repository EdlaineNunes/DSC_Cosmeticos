/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.logicaaplicacao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 *
 * @author edlaine
 */
@Entity
@DiscriminatorValue(value = "2")
public class PessoaJuridica extends Pessoa implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PessoaFisica representante;
    
    @Column (name="razaoSocial", nullable= false, length=250)
    private String razaoSocial;
    
    @Column (name="nomeFantasia", nullable= false, length=250)
    private String nomeFantasia;
    
    @Column (name="cnpj", nullable=false, length=20, unique=true)
    private String cnpj;
    
    @Column (name="rua", nullable=false, length=150)
    private String rua;
    
    @Column (name="numero", nullable=false, length=9)
    private String numero;
    
    @Column (name="bairro", nullable=false, length=200)
    private String bairro;
    
    @Column (name="complemento", length=200)
    private String complemento;
    
    @Column (name="cidade", nullable=false, length=200)
    private String cidade;    
    
    @Version
    private int versao;

    public PessoaJuridica(){
        super();
        this.representante = null;
        this.razaoSocial = "";
        this.nomeFantasia = "";
        this.cnpj = "";
        this.rua = "";
        this.numero = "";
        this.bairro = "";
        this.complemento = "";
        this.cidade = "";
        this.versao = 1;
    }
    
    public PessoaJuridica( PessoaFisica representante, String razaoSocial, 
            String nomeFantasia, String cnpj, String rua, 
            String numero, String bairro, String complemento, 
            String cidade) {
        super();
        this.representante = representante;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.versao = versao;
    }

    public PessoaFisica getRepresentante() {
        return representante;
    }

    public void setRepresentante(PessoaFisica representante) {
        this.representante = representante;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.razaoSocial);
        hash = 97 * hash + Objects.hashCode(this.nomeFantasia);
        hash = 97 * hash + Objects.hashCode(this.cnpj);
        hash = 97 * hash + Objects.hashCode(this.rua);
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.bairro);
        hash = 97 * hash + Objects.hashCode(this.complemento);
        hash = 97 * hash + Objects.hashCode(this.cidade);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.razaoSocial, other.razaoSocial)) {
            return false;
        }
        if (!Objects.equals(this.nomeFantasia, other.nomeFantasia)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomeFantasia;
    }
}