package com.gray.tutiontribe.entity;

import com.gray.tutiontribe.entity.Branch;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-12T13:12:40")
@StaticMetamodel(Institute.class)
public class Institute_ { 

    public static volatile SingularAttribute<Institute, String> name;
    public static volatile SingularAttribute<Institute, Long> id;
    public static volatile SetAttribute<Institute, Branch> branchSet;

}