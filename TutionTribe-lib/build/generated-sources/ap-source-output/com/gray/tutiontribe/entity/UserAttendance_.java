package com.gray.tutiontribe.entity;

import com.gray.tutiontribe.entity.Attendance;
import com.gray.tutiontribe.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-12T16:05:56")
@StaticMetamodel(UserAttendance.class)
public class UserAttendance_ { 

    public static volatile SingularAttribute<UserAttendance, Long> id;
    public static volatile SingularAttribute<UserAttendance, User> user;
    public static volatile SingularAttribute<UserAttendance, Attendance> attendance;
    public static volatile SingularAttribute<UserAttendance, String> status;

}