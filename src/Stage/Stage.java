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
        List<Fighter> fighters = Arrays.asList(new Knight(difficulty, round), new Mage(difficulty, round), new Archer(difficulty, round));
        Random random = new Random();
        this.enemy = fighters.get(random.nextInt(fighters.size())); // 적 파이터를 랜덤으로 선택
        System.out.println("적이 설정되었습니다. \n ");
        enemy.showDescript();
    }

    @Override
    public boolean battleResult(Fighter user) {
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
        if (enemy.getResource().get("HP") <= 0) {
            return true; // 사용자 승리
        } else {
            return false; // 사용자 패배
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
