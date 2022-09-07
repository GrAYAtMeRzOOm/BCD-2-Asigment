package com.gray.tutiontribe.entity;

import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-07T21:57:00")
@StaticMetamodel(Attendance.class)
public class Attendance_ { 

    public static volatile SingularAttribute<Attendance, Timestamp> dateTime;
    public static volatile SingularAttribute<Attendance, User> lecturer;
    public static volatile SetAttribute<Attendance, User> students;
    public static volatile SingularAttribute<Attendance, Lecture> lecture;
    public static volatile SingularAttribute<Attendance, Long> id;

}