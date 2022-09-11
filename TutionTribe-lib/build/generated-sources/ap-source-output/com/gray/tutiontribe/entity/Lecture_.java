package com.gray.tutiontribe.entity;

import com.gray.tutiontribe.entity.Attendance;
import com.gray.tutiontribe.entity.Branch;
import com.gray.tutiontribe.entity.User;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-11T15:13:47")
@StaticMetamodel(Lecture.class)
public class Lecture_ { 

    public static volatile SingularAttribute<Lecture, Timestamp> startedTime;
    public static volatile SingularAttribute<Lecture, Timestamp> endedTime;
    public static volatile SingularAttribute<Lecture, String> subject;
    public static volatile SingularAttribute<Lecture, User> presentedUser;
    public static volatile SingularAttribute<Lecture, Long> id;
    public static volatile SingularAttribute<Lecture, Branch> branch;
    public static volatile SingularAttribute<Lecture, Attendance> attendances;

}