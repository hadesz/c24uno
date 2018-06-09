package eu.hadesz.test.c24uno.entity;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ActionDecorator implements Card {

    private final Action action;
    private final Card card;

    @Override
    public List<String> getProperties() {
        List<String> properties = card.getProperties();
        properties.add(action.name());
        return properties;
    }

    @Override
    public Integer getScore() {
        return action.getScore();
    }

    @Override
    public boolean matches(Card card) {
        return card.getProperties().contains(action.name()) || this.card.matches(card);
    }
}
