package br.edu.ifnmg.logicaaplicacao;

import br.edu.ifnmg.logicaaplicacao.Pessoa;
import br.edu.ifnmg.logicaaplicacao.TransacaoItem;
import br.edu.ifnmg.logicaaplicacao.TransacaoTipo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-03T01:27:03")
@StaticMetamodel(Transacao.class)
public class Transacao_ { 

    public static volatile ListAttribute<Transacao, TransacaoItem> itens;
    public static volatile SingularAttribute<Transacao, TransacaoTipo> tipo;
    public static volatile SingularAttribute<Transacao, Pessoa> pessoa;
    public static volatile SingularAttribute<Transacao, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Transacao, Long> id;
    public static volatile SingularAttribute<Transacao, Date> criacao;
    public static volatile SingularAttribute<Transacao, Integer> version;

}