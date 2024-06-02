package Card.impl;

import Card.Card;

import java.util.Arrays;
import java.util.HashMap;

public class DefenseCard extends Card {
    public DefenseCard() {
        super(new HashMap<>() {{
            put("defense", Arrays.asList(1, 0)); // 예: 5의 방어력을 나에게
        }}, "기본 방어 카드로 영구적으로 방어력을 1 올려줍니다.");
    }

    public DefenseCard(int defense, int target) {
        super(new HashMap<>() {{
            put("defense", Arrays.asList(defense, target));
        }}, String.format("방어 카드로 영구적으로 방어력을 %d 올려줍니다.", defense));
    }
}
