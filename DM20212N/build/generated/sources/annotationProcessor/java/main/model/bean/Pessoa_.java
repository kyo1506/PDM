package model.bean;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, Integer> idade;
	public static volatile SingularAttribute<Pessoa, Estado> estado;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, Long> id;

	public static final String IDADE = "idade";
	public static final String ESTADO = "estado";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

