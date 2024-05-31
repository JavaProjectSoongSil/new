package Fighter.impl;

import Card.Card;
import Fighter.Fighter;

import java.util.HashMap;
import java.util.Map;

public class Knight extends Fighter {

    public Knight() {
        resource = new HashMap<>();
        resource.put("HP", 200);
        resource.put("hand", 2);
        resource.put("Attack", 15); // 공격력
        resource.put("Defense", 20); // 방어력
    }

}
