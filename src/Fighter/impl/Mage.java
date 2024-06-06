package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;
public class Mage extends Fighter {
    public Mage(String name, String difficulty, int round) {
        super(name,
                "Mage",
                (int) Math.round(80 * (1 + ((double) round / 10))),
                (int) Math.round(5 * (1 + ((double) round / 10))),
                (int) Math.round(5 * (1 + ((double) round / 10))),
                4);
        if (difficulty.equals("상")) {
            resource.put("HP", (int) Math.round(120 * (1 + ((double) round / 10)))); // HP를 높임
            resource.put("attackPower", (int) Math.round(25 * (1 + ((double) round / 10)))); // 공격력을 높임
            resource.put("defensePower", (int) Math.round(7 * (1 + ((double) round / 10)))); // 방어력을 높임
        } else if (difficulty.equals("하")) {
            resource.put("HP", (int) Math.round(80 * (1 + ((double) round / 10)))); // HP를 낮춤
            resource.put("attackPower", (int) Math.round(15 * (1 + ((double) round / 10)))); // 공격력을 낮춤
            resource.put("defensePower", (int) Math.round(3 * (1 + ((double) round / 10)))); // 방어력을 낮춤
        }
        // 카드 추가
        cardSet.add(new AttackCard(20,1));
        cardSet.add(new DefenseCard(1,0));
        cardSet.add(new HealCard(20,0));

        resource.put("specialPower", 20);
    }

    @Override
    public void gainSpecialPower() {
        // specialPower 키가 없는 경우, 메서드를 종료
        // specialPower는 Mage 클래스에서만 존재함.
        if (!resource.containsKey("specialPower")) {
            return;
        }

        int currentSpecialPower = resource.get("specialPower");
        currentSpecialPower += 20; // 한 턴마다 20의 specialPower를 얻음
        resource.put("specialPower", currentSpecialPower);

        if (currentSpecialPower > 100) { // specialPower가 100을 넘어가면
            int currentAttackPower = resource.get("attackPower");
            currentAttackPower += 3; // 공격력이 5씩 늘어남
            resource.put("attackPower", currentAttackPower);
            resource.put("specialPower", currentSpecialPower - 100); // specialPower를 100만큼 감소
            System.out.println("--- 특수능력 발동! 공격력이 3 증가합니다.");
        }
    }
}
