package Fighter.impl;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;

import java.util.HashMap;
import java.util.Map;

public class Knight extends Fighter {
    public Knight() {
        super("Knight", 200, 15, 115, 2);
        // 카드 추가
        cardSet.add(new AttackCard());
        cardSet.add(new DefenseCard());
        cardSet.add(new HealCard());
    }
}
