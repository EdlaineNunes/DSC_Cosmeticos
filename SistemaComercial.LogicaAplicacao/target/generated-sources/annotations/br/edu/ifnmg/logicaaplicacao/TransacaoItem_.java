package br.edu.ifnmg.logicaaplicacao;

import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.Transacao;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-17T15:34:58")
@StaticMetamodel(TransacaoItem.class)
public class TransacaoItem_ { 

    public static volatile SingularAttribute<TransacaoItem, Transacao> transacao;
    public static volatile SingularAttribute<TransacaoItem, Produto> produto;
    public static volatile SingularAttribute<TransacaoItem, Integer> quantidade;
    public static volatile SingularAttribute<TransacaoItem, BigDecimal> valorUnitario;

}