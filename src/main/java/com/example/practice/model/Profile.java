package com.example.practice.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileid;

    @Column
    private Long iin;
    private Long number_of_id;

    @OneToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;

    private Long userid;
}
