package com.example.practice.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageid;

    @Lob
    private byte [] image;
    private String type;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;
    private Long userid;


    public Image( byte[] image, String type, Long userid) {
        this.image = image;
        this.type = type;
        this.userid = userid;
    }

    public Image() {
    }

}
