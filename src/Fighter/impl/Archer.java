package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;


public class Archer extends Fighter {
    public Archer() {
        super("Archer", 100, 25, 7, 2);
        // 카드 추가
        cardSet.add(new AttackCard(18, 1));
        cardSet.add(new DefenseCard(7, 0));
        cardSet.add(new HealCard(12, 0));
    }
}