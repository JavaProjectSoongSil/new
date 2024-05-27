package Stage;
import java.util.Scanner;
import Fighter.Fighter;
import Card.Card;
import java.util.Map;

public class Stage implements StageInter{
    Map<String,Integer> userChange;
    Map<String,Integer> enemyChange;
    Fighter enemy;
    int[] reward;
    int stagenum=0;
    @Override
    public void setEnemyAndReward( int difficulty,Fighter user) {
        int card=user.getDeckSet().size();
    }

    @Override
    public boolean battleResult(Fighter user) {
        user.showFighterInform();
        enemy.showFighterInform();
        System.out.println("카드를 고르세요");
        Card[] userCard=user.chooseCards();
        Card[] enemyCard=enemy.chooseCards(true);
        //카드의 작업에 따라 userChage와 enemyChange를 업데이트
        user.setFighterResource(userChange);
        enemy.setFighterResource(enemyChange);
        int userHp=user.getResource().get("HP");
        int enemyHp=enemy.getResource().get("HP");
        return userHp<=0||enemyHp<=0;
    }

    @Override
    public void endStage(Fighter user, Fighter enemy) {

    }

    @Override
    public void showEnemyInform() {
        enemy.showFighterInform();
    }

    @Override
    public void showUserInform(Fighter user) {
        user.showFighterInform();
    }

}
