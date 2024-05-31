package Fighter;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import Card.Card;
public abstract class Fighter implements FighterInter {
    protected Map<String,Integer> resource;//hand,"HP"

    @Override
    public void introduceFighter() {
        //파이터의 소개 정보 출력
    }

    @Override
    public void chooseFighter(String fighter) {

    }

    @Override
    public void makeStage() {

    }

    @Override
    public String inCombat() {
        return null;
    }

    @Override
    public void endStage() {


    }

    @Override
    public void endGame() {

    }
}