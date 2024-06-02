package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;
public class Mage extends Fighter {
    public Mage(String difficulty) {
        super("Mage", 80, 15, 5, 5);
        if (difficulty.equals("상")) {
            resource.put("HP", 100); // HP를 높임
            resource.put("attackPower", 20); // 공격력을 높임
            resource.put("defensePower", 7); // 방어력을 높임
        } else if (difficulty.equals("하")) {
            resource.put("HP", 60); // HP를 낮춤
            resource.put("attackPower", 10); // 공격력을 낮춤
            resource.put("defensePower", 3); // 방어력을 높임
        }
        // 카드 추가
        cardSet.add(new AttackCard(25, 1));
        cardSet.add(new AttackCard(30, 1));
        cardSet.add(new DefenseCard(1, 0));
        cardSet.add(new HealCard(25, 0));
        cardSet.add(new HealCard(30, 0));
    }
}
