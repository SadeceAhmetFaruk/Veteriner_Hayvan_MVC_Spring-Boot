package Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "contact_info",nullable = false)
    private String contact_info;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "phone_number",nullable = false)
    private String phone_number;

    @Email
    @Column(name = "mail",nullable = false)
    private String mail;

    @Column(name = "role")
    private Role role;


}
