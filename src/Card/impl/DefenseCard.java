package Card.impl;

import Card.Card;

import java.util.Arrays;
import java.util.HashMap;

public class DefenseCard extends Card {
    public DefenseCard() {
        super(new HashMap<>() {{
            put("defense", Arrays.asList(5, 0)); // 예: 5의 방어력을 나에게
        }}, "기본 방어 카드로 5의 피해를 막아줍니다.");
    }

    public DefenseCard(int defense, int target) {
        super(new HashMap<>() {{
            put("defense", Arrays.asList(defense, target));
        }}, String.format("공격 카드로 %d의 피해를 상대방에게 줍니다.", defense));
    }
}
