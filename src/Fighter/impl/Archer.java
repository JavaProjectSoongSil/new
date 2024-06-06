package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;


public class Archer extends Fighter {
    public Archer(String name, String difficulty, int round) {
        super(name,
                "Archer",
                (int) Math.round(100 * (1 + ((double) round / 10))),
                (int) Math.round(35 * (1 + ((double) round / 10))),
                (int) Math.round(5 * (1 + ((double) round / 10))),
                2);
        if (difficulty.equals("상")) {
            resource.put("HP", (int) Math.round(120 * (1 + ((double) round / 10)))); // HP를 높임
            resource.put("attackPower", (int) Math.round(35 * (1 + ((double) round / 10)))); // 공격력을 높임
            resource.put("defensePower", (int) Math.round(7 * (1 + ((double) round / 10)))); // 방어력을 높임
        } else if (difficulty.equals("하")) {
            resource.put("HP", (int) Math.round(80 * (1 + ((double) round / 10)))); // HP를 낮춤
            resource.put("attackPower", (int) Math.round(25 * (1 + ((double) round / 10)))); // 공격력을 낮춤
            resource.put("defensePower", (int) Math.round(3 * (1 + ((double) round / 10)))); // 방어력을 낮춤
        }
        // 카드 추가
        cardSet.add(new AttackCard());
        cardSet.add(new DefenseCard());
        cardSet.add(new HealCard());
    }

    @Override
    public void gainSpecialPower() {

    }
}