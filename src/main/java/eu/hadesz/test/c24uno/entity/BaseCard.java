package eu.hadesz.test.c24uno.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseCard implements Card {

    private Integer score = 0;

    @Override
    public List<String> getProperties() {
        ArrayList<String> params = new ArrayList<>();
        params.add(score.toString());
        return params;
    }

    @Override
    public boolean matches(Card card) {
        return score.equals(card.getScore());
    }
}
