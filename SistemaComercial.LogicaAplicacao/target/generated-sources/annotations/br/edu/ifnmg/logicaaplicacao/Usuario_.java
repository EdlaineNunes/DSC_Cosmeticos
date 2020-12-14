package br.edu.ifnmg.logicaaplicacao;

import br.edu.ifnmg.logicaaplicacao.Funcao;
import br.edu.ifnmg.logicaaplicacao.Genero;
import br.edu.ifnmg.logicaaplicacao.Status;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-14T14:45:36")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Funcao> funcao;
    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, Genero> sexo;
    public static volatile SingularAttribute<Usuario, String> login;
    public static volatile SingularAttribute<Usuario, Integer> version;
    public static volatile SingularAttribute<Usuario, Status> status;

}