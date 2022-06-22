package com.example.practice.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String imageid;

    private String name;

    private String contentType;

    private Long size;

    private String date;

    @Lob
    private byte [] image;
    private String type;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;
    private Long userid;

    public Image(byte[] image, String type, Long userid) {
        this.image = image;
        this.type = type;
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public Image() {
    }

}
