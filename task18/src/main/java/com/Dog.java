package com;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "dogs")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dog implements Backupable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    public User user;

    @Column(name = "user_id")
    private Long userId;

    @Override
    public String toString() {
        return "Dog{" +
                "\n\tid=" + id +
                ", \n\tname='" + name + '\'' +
                ", \n\tbreed='" + breed + '\'' +
                ", \n\tuser_id='" + userId + '\'' +
                "\n}";
    }
}
