package Fighter;

import java.util.Map;
import java.util.Set;

import Card.Card;
public interface FighterInter {
    void introduceFighter();
    void chooseFighter(String fightername);
    void makeStage();
    String inCombat();
    void endStage();
    void endGame();//show rank
}
