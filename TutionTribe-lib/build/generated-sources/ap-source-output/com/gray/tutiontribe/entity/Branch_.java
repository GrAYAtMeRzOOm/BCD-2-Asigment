package com.gray.tutiontribe.entity;

import com.gray.tutiontribe.entity.Institute;
import com.gray.tutiontribe.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-09T17:57:15")
@StaticMetamodel(Branch.class)
public class Branch_ { 

    public static volatile SingularAttribute<Branch, String> city;
    public static volatile SingularAttribute<Branch, String> name;
    public static volatile SingularAttribute<Branch, Institute> institute;
    public static volatile SingularAttribute<Branch, Long> id;
    public static volatile SetAttribute<Branch, User> users;

}