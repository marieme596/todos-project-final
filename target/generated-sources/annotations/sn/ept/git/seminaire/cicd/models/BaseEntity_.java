package sn.ept.git.seminaire.cicd.models;

import java.time.Instant;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Instant> createdDate;
	public static volatile SingularAttribute<BaseEntity, Boolean> deleted;
	public static volatile SingularAttribute<BaseEntity, Instant> lastModifiedDate;
	public static volatile SingularAttribute<BaseEntity, UUID> id;
	public static volatile SingularAttribute<BaseEntity, Integer> version;
	public static volatile SingularAttribute<BaseEntity, Boolean> enabled;

	public static final String CREATED_DATE = "createdDate";
	public static final String DELETED = "deleted";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String ENABLED = "enabled";

}

