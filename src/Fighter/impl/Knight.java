package Fighter.impl;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;

import java.util.HashMap;
import java.util.Map;

public class Knight extends Fighter {

    public Knight(String name, String difficulty, int round) {
        super(name,
                "Knight",
                (int) Math.round(200 * (1 + ((double) round / 10))),
                (int) Math.round(10 * (1 + ((double) round / 10))),
                (int) Math.round(15 * (1 + ((double) round / 10))),
                2);
        if (difficulty.equals("상")) {
            resource.put("HP", (int) Math.round(250 * (1 + ((double) round / 10)))); // HP를 높임
            resource.put("attackPower", (int) Math.round(20 * (1 + ((double) round / 10)))); // 공격력을 높임
            resource.put("defensePower", (int) Math.round(20 * (1 + ((double) round / 10)))); // 방어력을 높임
        } else if (difficulty.equals("하")) {
            resource.put("HP", (int) Math.round(150 * (1 + ((double) round / 10)))); // HP를 낮춤
            resource.put("attackPower", (int) Math.round(10 * (1 + ((double) round / 10)))); // 공격력을 낮춤
            resource.put("defensePower", (int) Math.round(10 * (1 + ((double) round / 10)))); // 방어력을 낮춤
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
