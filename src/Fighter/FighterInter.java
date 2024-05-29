package Fighter;

import java.util.Map;
import java.util.Set;

import Card.Card;
public interface FighterInter {
    Card[] chooseCards(Boolean isEnemy);//show card and choose,enemy will random choose
    public Set<Card> getDeckSet();
    public Map<String,Integer> getResource();
    public void showdescript();
    void setFighterResource(Map<String,Integer> cards);
    void showInventory();
    void getreward(Card reward);
}
