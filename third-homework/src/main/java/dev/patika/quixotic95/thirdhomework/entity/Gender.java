package dev.patika.quixotic95.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Gender {

    MALE('M'),
    FEMALE('F'),
    OTHER('O');

    @Getter
    @Setter
    private char symbol;

}
