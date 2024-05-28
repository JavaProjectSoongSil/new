package Game;

import Fighter.Fighter;
import Stage.Stage;

import java.util.Map;
import java.util.Set;

public class Game implements GameInter{
    int rank;
    Set<Fighter> userset;
    Set<Fighter> enemyset;
    Fighter user;
    Map<String,Integer>diff;
    int difficulty;
    String name;
    Stage stage=new Stage();
    public Game(String difficulty,String name) {
        //set user and enemy
        //set diff
        this.difficulty=diff.get(difficulty);
        this.name = name;
        rank = 0;
        //difficulty로 user가 만들어진 캐릭터와 enemy의 초기값이 다름
    }

    @Override
    public Fighter chooseFighter(String fighter) {
        return null;
    }

    @Override
    public void makestage() {
        stage.setEnemyAndReward(difficulty,user);
    }

    @Override
    public String inCombat() {
        while(stage.battleResult(user));
        if(user.getResource().get("HP")<=0) {
            System.out.println("당신은 죽었습니다.");
            return "그만";
        }
        else {
            endstage();
            return "다시";
        }
    }

    @Override
    public void endstage() {
        stage.endStage(user);
        rank+=difficulty*1;
    }

    @Override
    public void endgame() {
        System.out.print(name+"\nYour rank is" +rank);
    }
}
