package com.example.practice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectid;

    @Column
    private String name;
    private int credit;

    @ManyToOne
    @JoinColumn(name = "programid", insertable = false, updatable = false)
    private Program program;
    private Long programid;

    public Subject(Long subjectid, String name, int credit, Long programid) {
        this.subjectid = subjectid;
        this.name = name;
        this.credit = credit;
        this.programid = programid;
    }
}
