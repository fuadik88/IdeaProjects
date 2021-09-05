package com.hibernate_1toMany_bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INSTRUCTOR")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inst_seq")
    @SequenceGenerator(name = "inst_seq", sequenceName = "INST_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INST_DETAIL_ID")
    private InstructorDetails instDetails;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Course> instCourses;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Instructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetails getInstDetails() {
        return instDetails;
    }

    public void setInstDetails(InstructorDetails instDetails) {
        this.instDetails = instDetails;
    }

    public List<Course> getInstCourses() {
        return instCourses;
    }

    public void setInstCourses(List<Course> instCourses) {
        this.instCourses = instCourses;
    }

    @Override
    public String toString() {
        return "Instructor" + " id= " + id + ", firstName= " + firstName +
                ", lastName= " + lastName + ", email= " + email + ", instDetails= " + instDetails;
    }

    public void add(Course course){
        if (course == null)
            instCourses = new ArrayList<>();     //Just to simplify inst.getInstCourses().add(c1) method.
        instCourses.add(course);
        course.setInstructor(this);
    }
}
