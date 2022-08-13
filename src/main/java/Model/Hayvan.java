package Model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
public class Hayvan {
    @Id
    @Column(name = "hayvan_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tür",nullable = false)
    private String tur;

    @Column(name = "cins",nullable = false)
    private String cins;

    @Column(name = "isim",nullable = false)
    private String isim;

    @Column(name = "yas",nullable = false)
    private String yas;

    @Email
    @Column(name = "açıklama",nullable = false)
    private String acıklama;


}
