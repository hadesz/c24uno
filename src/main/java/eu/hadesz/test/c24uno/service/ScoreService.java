package eu.hadesz.test.c24uno.service;

import eu.hadesz.test.c24uno.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    public Integer sumCards(List<Card> cards) {
        return cards.stream().mapToInt(Card::getScore).sum();
    }
}
