package Game;
import Fighter.Fighter;

import java.util.Set;

public interface GameInter { //난이도 설정
    void introduceFighter();
    void chooseFighter(String fightername, String name);
    void makeStage();
    String inCombat();
    void endStage();
    void endGame();//show rank
}
