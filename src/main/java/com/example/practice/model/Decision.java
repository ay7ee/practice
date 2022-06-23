package com.example.practice.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "decision")
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long decisionid;
    private boolean check;

    @ManyToOne
    @JoinColumn(name = "subjectid", insertable = false, updatable = false)
    private Subject subject;
    private Long subjectid;

    @ManyToOne
    @JoinColumn(name = "requestid", insertable = false, updatable = false)
    private Request request;
    private Long requestid;

    @ManyToOne
    @JoinColumn(name = "userid" , insertable = false, updatable = false)
    private User user;
    private Long userid;

}
