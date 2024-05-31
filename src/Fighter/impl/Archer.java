package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Fighter.Fighter;


public class Archer extends Fighter {
    public Archer() {
        resource = new HashMap<>();
        resource.put("HP", 100);
        resource.put("hand", 2);
        resource.put("Attack", 30); // 공격력
        resource.put("Defense", 5); // 방어력
    }
}
