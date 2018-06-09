package eu.hadesz.test.c24uno.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardMatcherTest {

    @Test
    public void matchesSameActionAndScore() {

        //GIVEN
        Card card1 = new ActionDecorator(Action.REVERSE, new BaseCard());
        Card card2 = new ActionDecorator(Action.REVERSE, new BaseCard());

        // WHEN
        boolean result = card1.matches(card2);

        // THEN
        assertTrue(result);
    }

    @Test
    public void notMatchesSameScoreDifferentAction() {

        //GIVEN
        Card card1 = new ActionDecorator(Action.REVERSE, new BaseCard());
        Card card2 = new ActionDecorator(Action.DRAW_2, new BaseCard());

        // WHEN
        boolean result = card1.matches(card2);

        // THEN
        assertFalse(result);
    }

    @Test
    public void matchesSameColorAndScore() {

        //GIVEN
        Card card1 = new ColorDecorator(Color.BLUE, new BaseCard());
        Card card2 = new ColorDecorator(Color.BLUE, new BaseCard());

        // WHEN
        boolean result = card1.matches(card2);

        // THEN
        assertTrue(result);
    }

    @Test
    public void matchesSameColorDifferentScore() {

        //GIVEN
        Card card1 = new ColorDecorator(Color.BLUE, new BaseCard(6));
        Card card2 = new ColorDecorator(Color.BLUE, new BaseCard(8));

        // WHEN
        boolean result = card1.matches(card2);

        // THEN
        assertTrue(result);
    }

    @Test
    public void matchesDifferentColorSameScore() {

        //GIVEN
        Card card1 = new ColorDecorator(Color.BLUE, new BaseCard(8));
        Card card2 = new ColorDecorator(Color.RED, new BaseCard(8));

        // WHEN
        boolean result = card1.matches(card2);

        // THEN
        assertTrue(result);
    }

    @Test
    public void matchesDifferentActionSameColor() {

        //GIVEN
        Card card1 = new ColorDecorator(Color.BLUE, new BaseCard(8));
        Card card2 = new ActionDecorator(Action.REVERSE, new ColorDecorator(Color.BLUE, new BaseCard()));

        // WHEN
        boolean result = card1.matches(card2);

        // THEN
        assertTrue(result);
    }
}