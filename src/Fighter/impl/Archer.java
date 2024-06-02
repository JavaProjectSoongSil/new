package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;


public class Archer extends Fighter {
    public Archer(String difficulty) {
        super("Archer", 100, 30, 5, 2);
        if (difficulty.equals("상")) {
            resource.put("HP", 120); // HP를 높임
            resource.put("attackPower", 35); // 공격력을 높임
            resource.put("defensePower", 7); // 방어력을 높임
        } else if (difficulty.equals("하")) {
            resource.put("HP", 80); // HP를 낮춤
            resource.put("attackPower", 25); // 공격력을 낮춤
            resource.put("defensePower", 3); // 방어력을 높임
        }
        // 카드 추가
        cardSet.add(new AttackCard(18, 1));
        cardSet.add(new DefenseCard(1, 0));
        cardSet.add(new HealCard(12, 0));
    }
}