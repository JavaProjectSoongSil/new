package Fighter;

import java.util.Map;
import java.util.Set;

import Card.Card;
public interface FighterInter {
    Card[] chooseCards();
    Card[] chooseCards(Boolean isEnemy);//show card and choose,enemy will random choose
    public Set<Card> getDeckSet();
    public Map<String,Integer> getResource();
    void showFighterInform();//after chooseCard get result about that round
    void setFighterResource(Map<String,Integer> cards);
    void showInventory();
    void getreward(int stagenum);
}
