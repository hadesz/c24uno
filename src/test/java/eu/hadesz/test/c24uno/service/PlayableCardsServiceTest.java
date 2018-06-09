package eu.hadesz.test.c24uno.service;

import eu.hadesz.test.c24uno.entity.Action;
import eu.hadesz.test.c24uno.entity.Card;
import eu.hadesz.test.c24uno.entity.Color;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static eu.hadesz.test.c24uno.service.CardFactory.create;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlayableCardsServiceTest {

    private PlayableCardsService underTest = new PlayableCardsService();

    @Test
    public void testFilterMatchingSameColorIsPlayable() {
        // GIVEN
        Card card1 = create(Color.BLUE, 10);
        Card card2 = create(Action.SKIP, Color.BLUE);
        Card card3 = create(Action.REVERSE, Color.BLUE);
        Card card4 = create(Color.BLUE, 4);
        List<Card> cards = Arrays.asList(
                card1,
                create(Color.RED, 3),
                card2,
                card3,
                card4
        );

        // WHEN
        List<Card> results = underTest.filterMatching(cards, create(Action.DRAW_2, Color.BLUE));

        // THEN
        assertThat(results.size(), is(4));
        assertThat(results, containsInAnyOrder(card1, card2, card3, card4));
    }

    @Test
    public void testFilterMatchingSameActionIsPlayable() {
        // GIVEN
        Card card1 = create(Action.DRAW_2, Color.YELLOW);
        Card card2 = create(Action.DRAW_2, Color.BLUE);
        List<Card> cards = Arrays.asList(
                create(Color.BLUE, 10),
                create(Color.RED, 3),
                card1,
                card2,
                create(Color.BLUE, 4)
        );

        // WHEN
        List<Card> results = underTest.filterMatching(cards, create(Action.DRAW_2, Color.GREEN));

        // THEN
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(card1, card2));

    }

    // This case could not be tested, because when a Wild card is on top of the discard pile,
    // the player who discarded it calls a color
    @Test
    public void testFilterMatchingWildCardOnTopOfDiscard() {
        // GIVEN
        Card card1 = create(Action.WILD, Color.WILD);
        List<Card> cards = Arrays.asList(
                create(Color.BLUE, 10),
                card1,
                create(Action.DRAW_2, Color.YELLOW),
                create(Action.DRAW_2, Color.BLUE),
                create(Color.BLUE, 4)
        );

        // WHEN
        List<Card> results = underTest.filterMatching(cards, create(Action.DRAW_4, Color.WILD));

        // THEN
        assertThat(results.size(), is(1));
        assertThat(results, containsInAnyOrder(card1));
    }

    @Test
    public void testFilterMatchingWildCardInHand() {
        // GIVEN
        Card card1 = create(Action.WILD, Color.WILD);
        List<Card> cards = Arrays.asList(
                create(Color.BLUE, 10),
                create(Color.RED, 3),
                create(Action.DRAW_2, Color.YELLOW),
                card1,
                create(Color.BLUE, 4)
        );

        // WHEN
        List<Card> results = underTest.filterMatching(cards, create(Color.GREEN, 7));

        // THEN
        assertThat(results.size(), is(1));
        assertThat(results, containsInAnyOrder(card1));
    }

    @Test
    public void testBestOption() {
        // GIVEN
        Card card1 = create(Action.DRAW_2, Color.YELLOW);
        Card card2 = create(Action.DRAW_4, Color.WILD);
        List<Card> cards = Arrays.asList(
                create(Color.BLUE, 10),
                create(Color.RED, 3),
                card1,
                card2,
                create(Color.BLUE, 4)
        );

        // WHEN
        Optional<Card> optionalCard = underTest.bestOption(cards, create(Action.DRAW_2, Color.GREEN));

        // THEN
        assertTrue(optionalCard.isPresent());
        assertThat(optionalCard.get(), is(card2));

    }
}