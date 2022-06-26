package com;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User implements Backupable {
    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Dog> dogs;

    @Override
    public String toString() {
        return "User{" +
                "\n\tid=" + id +
                ", \n\tfirstName='" + firstName + '\'' +
                ", \n\tlastName='" + lastName + '\'' +
                "\n}";
    }
}
