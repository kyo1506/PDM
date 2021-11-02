package model.bean;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserAuth.class)
public abstract class UserAuth_ {

	public static volatile SingularAttribute<UserAuth, String> password;
	public static volatile SingularAttribute<UserAuth, Long> id;
	public static volatile SingularAttribute<UserAuth, String> email;
	public static volatile SingularAttribute<UserAuth, String> username;

	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}

