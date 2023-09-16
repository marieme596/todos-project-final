package sn.ept.git.seminaire.cicd.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tag.class)
public abstract class Tag_ extends sn.ept.git.seminaire.cicd.models.BaseEntity_ {

	public static volatile SingularAttribute<Tag, String> name;
	public static volatile SingularAttribute<Tag, String> description;
	public static volatile SetAttribute<Tag, Todo> todos;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String TODOS = "todos";

}

