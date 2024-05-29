package Game;
import Fighter.Fighter;

import java.util.Set;

public interface GameInter { //난이도 설정
    public void introduceFighter();
    public Fighter chooseFighter(String fighterIndex);
    public void makestage();
    String inCombat();
    void endstage();
    void endgame();//show rank
}


