/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gray.tutiontribe.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author grays
 */
@Entity
public class Lecture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp startedTime;
    private Timestamp endedTime;
    private String subject;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "presented_user_id", referencedColumnName = "id")
    private User presentedUser;
    
    @OneToMany(mappedBy = "lecture")
    private Set<Attendance> attendances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Timestamp startedTime) {
        this.startedTime = startedTime;
    }

    public String getSubject() {
        return subject;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    
    public Timestamp getEndedTime() {
        return endedTime;
    }

    public void setEndedTime(Timestamp endedTime) {
        this.endedTime = endedTime;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public User getPresentedUser() {
        return presentedUser;
    }

    public void setPresentedUser(User presentedUser) {
        this.presentedUser = presentedUser;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecture)) {
            return false;
        }
        Lecture other = (Lecture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gray.tutiontribe.enitity.Lecture[ id=" + id + " ]";
    }
    
}
