package Game;
import Fighter.Fighter;

import java.util.Set;

public interface GameInter { //난이도 설정
    public Fighter chooseFighter(int fighterIndex);
    public void makestage();
    void inCombat();
    void endstage();
    void endgame(Fighter user);//show rank
}


