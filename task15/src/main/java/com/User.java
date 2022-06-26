package com;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    //@SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    // @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Dog> dogs;
}

