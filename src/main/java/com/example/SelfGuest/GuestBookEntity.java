package com.example.SelfGuest;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class GuestBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String comments;

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public GuestBookEntity(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }
}
