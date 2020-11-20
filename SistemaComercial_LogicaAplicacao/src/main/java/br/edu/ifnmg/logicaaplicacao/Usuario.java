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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author edlaine
 */
@Entity
@Table(name = "user")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Column(name="idUsuario")
    private Long id;
    
    @Column(length=250, nullable=false)
    private String nome;
    
    @Column(length=15, nullable=false, unique=true)
    private String cpf;
    
    //@Column(length=2, nullable=false)
    @Transient
    private Sexo sexo;
    
    @Column(length=20, nullable=false, unique=true)
    private String login;
    
    @Column(length=20, nullable=false)
    private String senha;
    
    // n persistido no bd
    @Transient
    private Pattern regex_cpf = Pattern.compile
        ("\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}"); //formatar cpf
    
    public Usuario() {
        this.id = 0L;
        this.nome = "";
        this.cpf = "00000000000";
        this.sexo = Sexo.M;
        this.login="";
        this.senha="";
    }
    
    public Usuario(long id, String nome, String cpf, Sexo sexo,
            String login, String senha){
        this.id = id;
        this.nome= nome;
        this.cpf= cpf;
        this.sexo= sexo;
        this.login= login;
        this.senha= senha;
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

    public String getCpf() {
//        if (cpf.length() == 11){
//        //formatação do cpf no formato 000.000.000-00
//            return cpf.substring(0, 3)+"." +
//                   cpf.substring(3, 6)+"." +
//                   cpf.substring(6, 9)+"-" +
//                   cpf.substring(9, 11);
//        }else
            return this.cpf;
    }

    public void setCpf(String cpf) {//throws ErroValidacaoException {
//        if(cpf.length() == 11){
//            //formatação do cpf no formato 000.000.000-00
//            Matcher m = regex_cpf.matcher(cpf);
//            if(m.matches())
//                this.cpf = cpf.replace(".", "").replace("-", "");
//            else
//                throw new ErroValidacaoException("CPF Inválido!");  
//        } else
            this.cpf=cpf; 
}

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.nome);
        hash = 31 * hash + Objects.hashCode(this.cpf);
        hash = 31 * hash + Objects.hashCode(this.sexo);
        hash = 31 * hash + Objects.hashCode(this.login);
        hash = 31 * hash + Objects.hashCode(this.senha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return this.nome;
    }
    
}
