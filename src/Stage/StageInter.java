package Stage;
import Fighter.Fighter;
public interface StageInter {
    void setEnemyAndReward(Fighter user);// 적이 강해지는 정도 1:1로 한정됨
    boolean battleResult(Fighter user);
    void showUserInform(Fighter user);
    void showEnemyInform();
    void endStage(Fighter user);
}
