package eu.hadesz.test.c24uno.service;

import eu.hadesz.test.c24uno.entity.Action;
import eu.hadesz.test.c24uno.entity.Card;
import eu.hadesz.test.c24uno.entity.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static eu.hadesz.test.c24uno.service.CardFactory.create;
import static org.junit.Assert.*;

public class ScoreServiceTest {

    private ScoreService underTest = new ScoreService();

    @Test
    public void testOnlyNumberCards() {
        // GIVEN
        List<Card> cards = Arrays.asList(
                create(Color.YELLOW, 10),
                create(Color.BLUE, 6),
                create(Color.RED, 4),
                create(Color.GREEN, 2)
        );

        // WHEN
        int result = underTest.sumCards(cards);

        // THEN
        assertEquals(22, result);
    }

    @Test
    public void testOnlyActionCards() {
        // GIVEN
        List<Card> cards = Arrays.asList(
                create(Action.REVERSE, Color.YELLOW),
                create(Action.DRAW_4, Color.WILD),
                create(Action.SKIP, Color.RED),
                create(Action.DRAW_2, Color.GREEN)
        );

        // WHEN
        int result = underTest.sumCards(cards);

        // THEN
        assertEquals(110, result);
    }

    @Test
    public void testCards() {
        // GIVEN
        List<Card> cards = Arrays.asList(
                create(Color.YELLOW, 10),
                create(Action.REVERSE, Color.YELLOW),
                create(Color.BLUE, 6),
                create(Color.RED, 4),
                create(Action.SKIP, Color.RED),
                create(Color.GREEN, 2)
        );

        // WHEN
        int result = underTest.sumCards(cards);

        // THEN
        assertEquals(62, result);
    }

}