package com.example.practice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "decisions")
public class Decision {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int decisionid;

    private Boolean checks;

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
