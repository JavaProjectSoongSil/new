package Stage;
import java.util.*;

import Fighter.Fighter;
import Card.Card;

public class Stage implements StageInter{
    @Override
    public void setEnemyAndReward(Fighter user) {

    }

    @Override
    public boolean battleResult(Fighter user) {
        return false;
    }

    @Override
    public void endStage(Fighter user) {
        //추가될 카드 정보 출력
    }


}
