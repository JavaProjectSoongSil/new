package Game;

import Fighter.Fighter;
import Stage.Stage;

import java.util.Map;
import java.util.Set;

import java.util.*;

public class Game implements GameInter {
    private Fighter player;
    private Fighter enemy;
    private Stage stage;
    private int score;

    public Game() {
        this.score = 0; // 초기 점수 설정
    }

    @Override
    public void introduceFighter() {
        System.out.println("파이터 소개: 각 파이터는 고유한 능력과 자원을 가지고 있습니다.");
    }

    @Override
    public void chooseFighter(String fighter) {
        if (fighter.equals("파이터1")) {
            player = new Fighter1();
        } else if (fighter.equals("파이터2")) {
            player = new Fighter2();
        } else {
            System.out.println("올바른 파이터를 선택하세요.");
        }
    }

    @Override
    public void makeStage() {
        stage = new Stage();
        stage.setEnemyAndReward(player);
        enemy = stage.getEnemy(); // 적 파이터 설정
        System.out.println("스테이지가 생성되었습니다.");
    }

    @Override
    public String inCombat() {
        Scanner scanner = new Scanner(System.in);
        while (player.getHP() > 0 && enemy.getHP() > 0) {
            System.out.println("카드를 뽑아주세요: ");
            player.drawCard();
            enemy.drawCard();
            player.attack(enemy);
            enemy.attack(player);
            System.out.println("현재 HP: 플레이어 - " + player.getHP() + ", 적 - " + enemy.getHP());
            if (player.getHP() <= 0) {
                System.out.println("플레이어가 패배했습니다.");
                return "그만";
            } else if (enemy.getHP() <= 0) {
                System.out.println("플레이어가 승리했습니다.");
                stage.endStage(player);
                return "계속";
            }
            System.out.println("그만하시겠습니까? 계속하시려면 '계속', 그만하시려면 '그만'을 입력해주세요.");
            String command = scanner.next();
            if (command.equals("그만")) {
                return "그만";
            }
        }
        return "계속";
    }

    @Override
    public void endStage() {
        int stageScore = stage.getRewards().getOrDefault("gold", 0); // 스테이지 보상 점수 가져오기
        score += stageScore;
        System.out.println("스테이지를 종료합니다. 보상을 받습니다: " + stageScore + "점. 현재 점수: " + score);
    }

    @Override
    public void endGame() {
        System.out.println("게임이 종료되었습니다. 최종 점수: " + score);
    }
}