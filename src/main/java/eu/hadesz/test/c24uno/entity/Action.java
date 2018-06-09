package eu.hadesz.test.c24uno.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Action {

    REVERSE(20),
    SKIP(20),
    DRAW_2(20),
    DRAW_4(50),
    // TODO: this should not be here
    WILD(50);

    private final Integer score;
}
