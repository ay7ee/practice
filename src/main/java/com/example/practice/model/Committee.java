package com.example.practice.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "committee")
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long committeeid;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;
    private Long userid;

    @ManyToOne
    @JoinColumn(name = "requestid", insertable = false, updatable = false)
    private Request request;
    private Long requestid;

    public Committee(Long committeeid, Long requestid, Long userid) {
        this.committeeid = committeeid;
        this.requestid = requestid;
        this.userid = userid;
    }

    public Committee() {

    }

    public Committee(Long requestid) {
        this.requestid = requestid;
    }
}
