package Fighter;

import java.util.Map;
import java.util.Set;

import Card.Card;
public interface FighterInter {
    public Card[] chooseCards(Boolean isEnemy);

    public Set<Card> getDeckSet();
    public Map<String,Integer> getResource();

    public void showDescript();

    public void setFighterResource(Map<String,Integer> change);
    public void showInventory();
    public void getreward(Card reward);
}
