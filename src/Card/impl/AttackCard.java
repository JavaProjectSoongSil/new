package Card.impl;

import Card.Card;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AttackCard extends Card {
    public AttackCard() {
        super(new HashMap<>() {{
            put("damage", Arrays.asList(10, 1)); // 예: 10의 피해를 상대에게
        }}, "기본 공격 카드로 10의 피해를 상대방에게 줍니다.");
    }

    public AttackCard(int damage, int target) {
        super(new HashMap<>() {{
            put("damage", Arrays.asList(damage, target));
        }}, String.format("공격 카드로 %d의 피해를 상대방에게 줍니다.", damage, target));
    }
}
