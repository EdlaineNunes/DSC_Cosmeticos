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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

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
    
    @Column(length=20, nullable=false, unique=true)
    private String cpf;
    
    @Enumerated (EnumType.STRING)
    private Genero sexo;
    
    @Column(length=20, nullable=false, unique=true)
    private String login;
    
    @Column(length=20, nullable=false)
    private String senha;
    
    //controle de concorrencia
    @Version
    private int version;
    
    @Enumerated (EnumType.STRING)
    private Funcao funcao;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public Usuario() {
        super();
        this.id = 0L;
        this.nome = "";
        this.cpf = "";
        this.sexo = Genero.Feminino;
        this.login="";
        this.senha="";
        this.version = 1;
        this.funcao = Funcao.Atendente;
        this.status = Status.Ativo;
    }
    
    

    public Usuario( String nome, String cpf, Genero sexo, 
            String login, String senha, Funcao funcao, 
            Status status) {
        super();
        this.id = 0L;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
        this.version = 1;
        this.funcao = funcao;
        this.status = status;
    }
       
    public Usuario( String login, String senha){
        super();
        this.id = 0L;
        this.nome= "";
        this.cpf= "";
        this.sexo = sexo;
        this.login= login;
        this.senha= senha;
        this.version = 1;
        this.funcao = funcao;
        this.status = status;
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
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.login);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + this.version;
        hash = 97 * hash + Objects.hashCode(this.funcao);
        hash = 97 * hash + Objects.hashCode(this.status);
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
        if (this.version != other.version) {
            return false;
        }
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
        if (this.funcao != other.funcao) {
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
