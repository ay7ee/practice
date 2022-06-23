package com.example.practice.model;


import com.example.practice.model.enums.Status_comission_request;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "comission_request")
public class ComissionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comissionRequestid;

    @OneToOne
    @JoinColumn(name = "requestid", insertable = false, updatable = false)
    private Request request;
    private Long requestid;

    @Enumerated(EnumType.STRING)
    private Status_comission_request status_comission_request;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "committee",
//            joinColumns = { @JoinColumn(name = "comissionRequestId") },
//            inverseJoinColumns = { @JoinColumn(name = "userid") }
//    )
//    List<User> users;
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

}
