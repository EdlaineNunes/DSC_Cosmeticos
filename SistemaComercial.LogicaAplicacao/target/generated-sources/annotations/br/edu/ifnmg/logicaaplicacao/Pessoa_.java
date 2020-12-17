package br.edu.ifnmg.logicaaplicacao;

import br.edu.ifnmg.logicaaplicacao.PessoaEmail;
import br.edu.ifnmg.logicaaplicacao.PessoaTelefone;
import br.edu.ifnmg.logicaaplicacao.PessoaTipo;
import br.edu.ifnmg.logicaaplicacao.Status;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T17:22:10")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile ListAttribute<Pessoa, PessoaEmail> emails;
    public static volatile SingularAttribute<Pessoa, PessoaTipo> tipo;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Long> id;
    public static volatile ListAttribute<Pessoa, PessoaTelefone> telefones;
    public static volatile SingularAttribute<Pessoa, Integer> version;
    public static volatile SingularAttribute<Pessoa, Status> status;

}