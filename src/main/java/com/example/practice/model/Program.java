package com.example.practice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programid;

    @Column
    private String name;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universityid", insertable = false, updatable = false)
    private University university;
    private Long universityid;

    public Program(Long programid, String name, String code, Long universityid) {
        this.programid = programid;
        this.name = name;
        this.code = code;
        this.universityid = universityid;
    }
    public Program( String name, String code, Long universityid) {
        this.name = name;
        this.code = code;
        this.universityid = universityid;
    }

    public Program() {
    }
}
