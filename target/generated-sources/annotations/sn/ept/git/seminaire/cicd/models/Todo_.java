package sn.ept.git.seminaire.cicd.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Todo.class)
public abstract class Todo_ extends sn.ept.git.seminaire.cicd.models.BaseEntity_ {

	public static volatile SingularAttribute<Todo, String> description;
	public static volatile SingularAttribute<Todo, Boolean> completed;
	public static volatile SingularAttribute<Todo, String> title;
	public static volatile SetAttribute<Todo, Tag> tags;

	public static final String DESCRIPTION = "description";
	public static final String COMPLETED = "completed";
	public static final String TITLE = "title";
	public static final String TAGS = "tags";

}

