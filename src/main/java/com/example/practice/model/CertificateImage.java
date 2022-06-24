package com.example.practice.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "certificate_image")
public class CertificateImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cimageid;

    @Lob
    private byte[] certificate_image;
    private String name;
    private String type;


    @OneToOne
    @JoinColumn(name = "certificateid", insertable = false, updatable = false)
    private Certificate certificate;

    private Long certificateid;

    public CertificateImage(String name, String type, byte[] certificate_image, Long certificateid) {
        this.name = name;
        this.type = type;
        this.certificate_image = certificate_image;
        this.certificateid =certificateid;
    }

    public CertificateImage() {
    }

    public byte[] getCertificate_image() {
        return certificate_image;
    }

    public String getType() {
        return type;
    }
}
