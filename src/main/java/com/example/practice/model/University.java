package com.example.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityid;

    @Column
    private String fullname;
    private String name;
    private String code;
    private String address;
    private String url;



    @OneToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    @NotNull
    private User user;
    private Long userid;
}
