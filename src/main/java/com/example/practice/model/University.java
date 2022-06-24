package com.example.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@NoArgsConstructor
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



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    @NotNull
    private User user;
    private Long userid;

    public University(Long universityid, String address, String code, String fullname, String name,  String url, Long userid) {
        this.universityid = universityid;
        this.fullname = fullname;
        this.name = name;
        this.code = code;
        this.address = address;
        this.url = url;
        this.userid = userid;
    }
}
