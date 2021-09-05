package com.hibernate_manyToMany_bi;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
public class Review {

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(name = "review_seq", sequenceName = "REVIEW_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERCOMMENT")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review " + "id = " + id + ", comment = " + comment;
    }
}
