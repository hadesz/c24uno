package eu.hadesz.test.c24uno.service;

import eu.hadesz.test.c24uno.entity.*;

public class CardFactory {

    public static Card create(Action action, Color color){
        return new ActionDecorator(action, new ColorDecorator(color, new BaseCard()));
    }

    public static Card create(Color color, Integer score){
        return new ColorDecorator(color, new BaseCard(score));
    }
}
