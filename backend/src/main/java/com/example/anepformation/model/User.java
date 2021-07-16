package com.example.anepformation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "company_email_unique", columnNames = "email_personnel"),
                @UniqueConstraint(name = "company_name_unique", columnNames = "email_professional")
        })
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email_personnel;

    @Column(nullable = false)
    private String email_professional;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String phone_personnel;

    private String phone_professional;

    private int valide;

    private UserType userType;


}
