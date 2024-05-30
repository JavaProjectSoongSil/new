package Stage;
import Fighter.Fighter;

import java.util.Set;

public interface StageInter {
    void setEnemyAndReward(Fighter user, Set<Fighter> enemyset);// 적이 강해지는 정도 1:1로 한정됨
    boolean battleResult(Fighter user);
    void endStage(Fighter user);
}
