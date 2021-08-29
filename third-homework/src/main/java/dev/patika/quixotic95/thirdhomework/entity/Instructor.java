package dev.patika.quixotic95.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Instructor extends Person {

    private String phoneNumber;

}
