package Fighter.impl;

import java.util.HashMap;
import java.util.Map;

import Card.Card;
import Fighter.Fighter;
public class Mage extends Fighter {
    public Mage() {
        resource = new HashMap<>();
        resource.put("HP", 80);
        resource.put("hand", 5);
        resource.put("Attack", 5); // 공격력
        resource.put("Defense", 5); // 방어력
    }

}
