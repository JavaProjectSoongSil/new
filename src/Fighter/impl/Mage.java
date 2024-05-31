package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;
public class Mage extends Fighter {
    public Mage() {
        super("Mage", 80, 5, 5, 5);
        // 카드 추가
        cardSet.add(new AttackCard(20, 1));
        cardSet.add(new DefenseCard(8, 0));
        cardSet.add(new HealCard(15, 0));
    }
}
