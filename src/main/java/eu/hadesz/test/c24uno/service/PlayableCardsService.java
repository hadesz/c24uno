package eu.hadesz.test.c24uno.service;

import eu.hadesz.test.c24uno.entity.Card;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayableCardsService {

    public List<Card> filterMatching(List<Card> hand, Card discardTop) {
        return hand.stream().filter(card -> card.matches(discardTop)).collect(Collectors.toList());
    }

    public Optional<Card> bestOption(List<Card> hand, Card discardTop) {
        return filterMatching(hand, discardTop).stream().max(Comparator.comparing(Card::getScore));
    }
}
