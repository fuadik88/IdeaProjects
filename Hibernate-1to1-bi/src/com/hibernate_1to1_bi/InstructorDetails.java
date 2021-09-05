package com.hibernate_1to1_bi;

import javax.persistence.*;

@Entity
@Table(name = "INSTRUCTOR_DETAILS")
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inst_details_seq")
    @SequenceGenerator(name = "inst_details_seq", sequenceName = "INST_DETAILS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "YT_CHANNEL")
    private String ytChannel;

    @Column(name = "HOBBY")
    private String hobby;

    @OneToOne(mappedBy = "instDetails", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                                                    CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetails() {
    }

    public InstructorDetails(String ytChannel, String hobby) {
        this.ytChannel = ytChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYtChannel() {
        return ytChannel;
    }

    public void setYtChannel(String ytChannel) {
        this.ytChannel = ytChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "id= " + id + ", ytChannel= " + ytChannel + ", hobby= " + hobby;
    }

}
