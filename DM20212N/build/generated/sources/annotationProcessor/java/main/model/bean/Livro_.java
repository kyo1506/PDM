package model.bean;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Livro.class)
public abstract class Livro_ {

	public static volatile SingularAttribute<Livro, String> nome;
	public static volatile SingularAttribute<Livro, Long> id;
	public static volatile ListAttribute<Livro, Autor> autores;

	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String AUTORES = "autores";

}

