package com.eeds.monolitico.GestionRoles.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_details")
public class UserDetail {
    @Id
    //@SequenceGenerator(name = "user_detail_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "lastName", length = 100)
    private String last_name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthDay")
    private Date birthDay;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
