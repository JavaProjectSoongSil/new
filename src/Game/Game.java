package Game;

import Fighter.Fighter;
import Fighter.impl.Archer;
import Fighter.impl.Knight;
import Fighter.impl.Mage;
import Stage.Stage;

import java.util.Map;
import java.util.Set;

import java.util.*;



public class Game implements GameInter {
    private Fighter player;
    private Fighter enemy;
    private Stage stage;
    private int score;
    private int round; // 현재 라운드를 추적하는 변수

    public Game() {
        this.score = 0; // 초기 점수 설정
        this.round = 1; // 초기 라운드 설정
    }

    @Override
    public void introduceFighter() {
        // 사용할 수 있는 모든 파이터의 정보를 출력
        Fighter[] fighters = {new Knight(), new Mage(), new Archer()};
        System.out.println("사용할 수 있는 파이터:");
        for (Fighter fighter : fighters) {
            fighter.showDescript();
        }
    }

    @Override
    public void chooseFighter(String fighterName) {
        switch (fighterName.toLowerCase()) {
            case "knight":
                player = new Knight();
                break;
            case "mage":
                player = new Mage();
                break;
            case "archer":
                player = new Archer();
                break;
            default:
                System.out.println("올바른 파이터를 선택하세요.");
                return; // 잘못된 입력일 경우, 더 이상 진행하지 않음
        }

        // 적 캐릭터 랜덤 설정
        Fighter[] fighters = {new Knight(), new Mage(), new Archer()};
        Random random = new Random();
        enemy = fighters[random.nextInt(fighters.length)];
        System.out.println("적 파이터가 설정되었습니다.");
        enemy.showDescript(); // 적 파이터의 정보 출력

    }

    @Override
    public void makeStage() {
        stage = new Stage();
        stage.setEnemyAndReward(player);
        System.out.println("라운드 " + round + "이 시작되었습니다.");
    }

    @Override
    public String inCombat() {
        Scanner scanner = new Scanner(System.in);
        while (player.getResource().get("HP") > 0 && enemy.getResource().get("HP") > 0) {
            System.out.println("카드를 뽑아주세요: ");
            player.chooseCards(false);
            enemy.chooseCards(true);
            stage.battleResult(player);
            System.out.println("현재 HP: 플레이어 - " + player.getResource().get("HP") + ", 적 - " + enemy.getResource().get("HP"));
            if (player.getResource().get("HP") <= 0) {
                System.out.println("플레이어가 패배했습니다.");
                return "그만";
            } else if (enemy.getResource().get("HP") <= 0) {
                System.out.println("플레이어가 승리했습니다.");
                endStage();
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
        stage.endStage(player);
        round++; // 라운드 증가
    }

    @Override
    public void endGame() {
        System.out.println("게임이 종료되었습니다. 최종 점수: " + score);
    }
}