package Card.impl;

import Card.Card;

import java.util.Arrays;
import java.util.HashMap;

public class HealCard extends Card {
    public HealCard() {
        super(new HashMap<>() {{
            put("heal", Arrays.asList(10, 0)); // 예: 10의 치유를 나에게
        }}, "기본 회복 카드로 10의 체력을 회복합니다.");
    }

    public HealCard(int heal, int target) {
        super(new HashMap<>() {{
            put("heal", Arrays.asList(heal, target));
        }}, String.format("회복 카드로 %d의 체력을 회복합니다.", heal));
    }
}
