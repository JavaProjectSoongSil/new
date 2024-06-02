package Fighter.impl;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;

import java.util.HashMap;
import java.util.Map;

public class Knight extends Fighter {

    public Knight(String difficulty) {
        super("Knight", 200, 15, 15, 2);
        if (difficulty.equals("상")) {
            resource.put("HP", 250); // HP를 높임
            resource.put("attackPower", 20); // 공격력을 높임
            resource.put("defensePower", 20); // 방어력을 높임
        } else if (difficulty.equals("하")) {
            resource.put("HP", 150); // HP를 낮춤
            resource.put("attackPower", 10); // 공격력을 낮춤
            resource.put("defensePower", 10); // 방어력을 낮춤
        }
        // 카드 추가
        cardSet.add(new AttackCard());
        cardSet.add(new DefenseCard());
        cardSet.add(new HealCard());
    }
}
