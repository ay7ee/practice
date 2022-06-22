package com.example.practice.model;

import com.example.practice.model.enums.Status_request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestid;

    public Request(Long requestid, Long certificateid, Long programid, Status_request status_request, Long universityid, Long userid) {
        this.requestid = requestid;
        this.userid = userid;
        this.universityid = universityid;
        this.certificateid = certificateid;
        this.programid = programid;
        this.status_request = status_request;
    }

    @OneToOne
    @JoinColumn(name = "userid", insertable = false, updatable= false)
    private User user;
    private Long userid;


    @OneToOne
    @JoinColumn(name = "universityid", insertable = false, updatable= false)
    private University university;
    private Long universityid;

    @OneToOne
    @JoinColumn(name = "certificateid", insertable = false, updatable= false)
    private Certificate certificate;
    private Long certificateid;

    @OneToOne
    @JoinColumn(name = "programid", insertable = false, updatable= false)
    private Program program;
    private Long programid;

    @Enumerated(EnumType.STRING)
    private Status_request status_request;

    public Request() {
    }

    public Request(Long requestid, Long userid, Long universityid, Long certificateid, Long programid, Status_request status_request) {
        this.requestid = requestid;
        this.userid = userid;
        this.universityid = universityid;
        this.certificateid = certificateid;
        this.programid = programid;
        this.status_request = status_request;
    }
}
