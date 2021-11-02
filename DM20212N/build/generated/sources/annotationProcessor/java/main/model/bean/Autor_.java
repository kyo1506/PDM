package model.bean;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autor.class)
public abstract class Autor_ {

	public static volatile ListAttribute<Autor, Livro> livros;
	public static volatile SingularAttribute<Autor, String> nome;
	public static volatile SingularAttribute<Autor, Long> id;

	public static final String LIVROS = "livros";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

