package Model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "HayvanSahibi")
public class HayvanSahibi {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "contact_info",nullable = false)
    private String contact_info;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "phone_number",nullable = false)
    private String phone_number;

    @Email
    @Column(name = "mail",nullable = false)
    private String mail;


}
