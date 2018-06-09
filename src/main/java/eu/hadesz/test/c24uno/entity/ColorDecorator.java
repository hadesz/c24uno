package eu.hadesz.test.c24uno.entity;


import eu.hadesz.test.c24uno.service.CardFactory;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ColorDecorator implements Card {


    private final Color color;
    private final Card card;


    @Override
    public List<String> getProperties() {
        List<String> properties = this.card.getProperties();
        properties.add(color.name());
        return properties;
    }

    @Override
    public Integer getScore() {
        return this.card.getScore();
    }

    @Override
    public boolean matches(Card card) {
        return color.equals(Color.WILD) || card.getProperties().contains(color.name()) || this.card.matches(card);
    }
}
