package com.gray.tutiontribe.entity;

import com.gray.tutiontribe.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-12T13:12:40")
@StaticMetamodel(UserRole.class)
public class UserRole_ { 

    public static volatile SingularAttribute<UserRole, String> roleName;
    public static volatile SingularAttribute<UserRole, Long> id;
    public static volatile SetAttribute<UserRole, User> roleUsers;

}