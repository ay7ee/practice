package com.example.practice.model;


import com.example.practice.model.enums.Status_comission_request;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comission_request")
public class ComissionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comissionRequestId;

    @OneToOne
    @JoinColumn(name = "requestid", insertable = false, updatable = false)
    private Request request;

    private Long requestid;

    @Enumerated(EnumType.STRING)
    private Status_comission_request status_comission_request;

}
