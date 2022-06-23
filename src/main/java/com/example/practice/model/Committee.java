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
    @JoinColumn(name = "comissionRequestid", insertable = false, updatable = false)
    private ComissionRequest comissionRequest;
    private Long comissionRequestid;

    public Committee(Long committeeid, Long comissionRequestid, Long userid) {
        this.committeeid = committeeid;
        this.comissionRequestid = comissionRequestid;
        this.userid = userid;
    }

    public Committee() {

    }
}
