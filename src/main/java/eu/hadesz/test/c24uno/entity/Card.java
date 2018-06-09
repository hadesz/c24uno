package eu.hadesz.test.c24uno.entity;

import java.util.List;

public interface Card {

    List<String> getProperties();

    Integer getScore();

    boolean matches(Card card);

}
