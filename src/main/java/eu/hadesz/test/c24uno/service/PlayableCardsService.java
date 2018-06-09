package eu.hadesz.test.c24uno.service;

import eu.hadesz.test.c24uno.entity.Card;

import java.util.List;
import java.util.stream.Collectors;

public class PlayableCardsService {

    public List<Card> filterMatching(List<Card> hand, Card discardTop) {
        return hand.stream().filter(card -> card.matches(discardTop)).collect(Collectors.toList());
    }
}
