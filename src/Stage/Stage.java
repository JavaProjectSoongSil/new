package Stage;
import java.util.*;

import Card.impl.AttackCard;
import Card.impl.DefenseCard;
import Card.impl.HealCard;
import Fighter.Fighter;
import Card.Card;
import Fighter.impl.Archer;
import Fighter.impl.Knight;
import Fighter.impl.Mage;

public class Stage implements StageInter {
    private Fighter enemy;
    private String difficulty;
    private int round;

    public Stage(String difficulty, int round) {
        this.difficulty = difficulty;
        this.round = round;
    }

    @Override
    public void setEnemyAndReward(Fighter user) {
        List<Fighter> fighters = Arrays.asList(new Knight("computer", difficulty, round), new Mage("computer", difficulty, round), new Archer("computer", difficulty, round));
        Random random = new Random();
        this.enemy = fighters.get(random.nextInt(fighters.size())); // 적 파이터를 랜덤으로 선택
        System.out.println("적이 설정되었습니다. \n ");
        enemy.showDescript();
    }

    @Override
    public boolean battleResult(Fighter user) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("\n카드의 정보를 확인하세요. (enemy:적 , user:사용자, start:라운드 시작)");

            input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "enemy":
                    System.out.println("\n=== 적의 카드 정보 ===");
                    Set<Card> enemyDeckSet = enemy.getDeckSet();
                    for (Card card : enemyDeckSet) {
                        for (Map.Entry<String, List<Integer>> entry : card.getCardInform().entrySet()) {
                            System.out.println("타입: " + entry.getKey() + ", 능력치: " + entry.getValue().get(0));
                        }
                        System.out.println("설명: " + card.getCardDescription());
                    }
                    break;
                case "user":
                    System.out.println("\n=== 사용자의 카드 정보 ===");
                    Set<Card> userDeckSet = enemy.getDeckSet();
                    for (Card card : userDeckSet) {
                        for (Map.Entry<String, List<Integer>> entry : card.getCardInform().entrySet()) {
                            System.out.println("타입: " + entry.getKey() + ", 능력치: " + entry.getValue().get(0));
                        }
                        System.out.println("설명: " + card.getCardDescription());
                    }
                    break;
                case "start":
                    System.out.println("다음 단계로 이동합니다.\n");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 'enemy', 'user' 또는 'start'를 입력해주세요.");
            }
        } while (!input.equals("start"));

        while (user.getResource().get("HP") > 0 && enemy.getResource().get("HP") > 0) {
            Card[] userCards = user.chooseCards(false);
            Card[] enemyCards = enemy.chooseCards(true);

            for (Card card : userCards) {
                System.out.println("\n===사용자 카드를 발동===");
                applyCardEffect(card, user, enemy);
                user.gainSpecialPower();
            }
            for (Card card : enemyCards) {
                System.out.println("\n===적이 카드를 발동===");
                applyCardEffect(card, enemy, user);
                enemy.gainSpecialPower();
            }
            int userHP = Math.max(user.getResource().get("HP"), 0);
            int enemyHP = Math.max(enemy.getResource().get("HP"), 0);
            System.out.println("\n사용자 HP : "+ userHP + " 적 HP : "+ enemyHP +"\n");
        }

        // 사용자가 승리하면 true를 반환하고, 패배하면 false를 반환
        if (user.getResource().get("HP") <= 0) {
            return false; // 사용자 패배
        } else {
            return true; // 사용자 승리
        }
    }
    private void applyCardEffect(Card card, Fighter caster, Fighter target) {
        Map<String, List<Integer>> effects = card.getCardInform();
        Map<String, Integer> casterResource = caster.getResource();
        Map<String, Integer> targetResource = target.getResource();

        for (Map.Entry<String, List<Integer>> entry : effects.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue().get(0);
            int targetType = entry.getValue().get(1);
            int newValue;

            if (targetType == 0) {
                switch(key) {
                    case "defense":
                        newValue = casterResource.get("defensePower") + value;
                        casterResource.put("defensePower", newValue);
                        caster.setFighterResource(casterResource);
                        System.out.println("--- " + value + "의 방어력을 영구적으로 얻었습니다.");
                        caster.getDeckSet().remove(card); // 카드를 caster의 cardSet에서 제거
                        break;
                    case "heal":
                        newValue = casterResource.get("HP") + value;
                        casterResource.put("HP", newValue);
                        caster.setFighterResource(casterResource);
                        System.out.println("--- " + value + "의 체력을 회복했습니다.");
                        break;
                }

            } else {
                switch(key) {
                    case "attack":
                        // target에게 효과 적용
                        int attack = casterResource.get("attackPower") + value - targetResource.get("defensePower");
                        if (attack > 0) {
                            newValue = targetResource.get("HP") - ((casterResource.get("attackPower") + value));
                            targetResource.put("HP", newValue);
                            target.setFighterResource(targetResource);
                            System.out.println("--- 상대방에게" + (casterResource.get("attackPower") + value+ "의 피해를 주었습니다."));
                        } else {
                            System.out.println("--- 상대방에게 피해를 주지 못했습니다.");
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void endStage(Fighter user) {
        System.out.println("스테이지가 종료되었습니다. 보상을 받습니다.\n");
        Random random = new Random();
        int attackValue = random.nextInt(36) + 5; // 5 ~ 40
        int defenseValue = random.nextInt(5) + 1; // 1 ~ 5
        int healValue = random.nextInt(36) + 5; // 5 ~ 40

        List<Card> cardTypes = Arrays.asList(
                new AttackCard(attackValue, 1),
                new DefenseCard(defenseValue, 0),
                new HealCard(healValue, 0)
        );

        Card rewardCard = cardTypes.get(random.nextInt(cardTypes.size()));

        user.getreward(rewardCard);
    }

}
