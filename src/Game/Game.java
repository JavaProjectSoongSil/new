package Game;

import Fighter.Fighter;
import Stage.Stage;

import java.util.Set;

public class Game implements GameInter{
    int Rank;
    Set<Fighter> userset;
    Set<Fighter> enemyset;
    Fighter user;
    int difficulty;
    String name;
    Stage stage=new Stage();
    public void Game(int difficulty,String name) {
        //set user and enemy
        this.difficulty = difficulty;
        this.name = name;
        Rank = 0;
        //difficulty로 user가 만들어진 캐릭터와 enemy의 초기값이 다름
    }

    @Override
    public Fighter chooseFighter(int fighterIndex) {
        return null;
    }

    @Override
    public void makestage() {
        stage.setEnemyAndReward(difficulty,user);
    }

    @Override
    public void inCombat() {
        while(stage.battleResult(user));
        if(user.getResource().get("HP")<=0)
            endgame(user);
    }

    @Override
    public void endstage() {

    }

    @Override
    public void endgame(Fighter user) {

    }
}
