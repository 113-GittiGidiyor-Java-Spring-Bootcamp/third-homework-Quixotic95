package dev.patika.quixotic95.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;

}
