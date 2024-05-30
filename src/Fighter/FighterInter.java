package Fighter;

import java.util.Map;
import java.util.Set;

import Card.Card;
public interface FighterInter {
    Card[] chooseCards(Boolean isEnemy);//show card and choose,enemy will random choose
    Set<Card> getDeckSet();
    Map<String,Integer> getResource();
    void showDescript();//캐릭터를 소개
    void setFighterResource(Map<String,Integer> cards);
    void showInventory();//가진 카드를 보여줌
    void getreward(Card reward);
}
