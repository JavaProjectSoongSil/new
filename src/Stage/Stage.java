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

    @Override
    public void setEnemyAndReward(Fighter user) {
        List<Fighter> fighters = Arrays.asList(new Knight(), new Mage(), new Archer());
        Random random = new Random();
        this.enemy = fighters.get(random.nextInt(fighters.size())); // 적 파이터를 랜덤으로 선택
        System.out.println("적과 보상이 설정되었습니다.");
    }

    @Override
    public boolean battleResult(Fighter user) {
        Card[] userCards = user.chooseCards(false);
        Card[] enemyCards = enemy.chooseCards(true);

        for (Card card : userCards) {
            applyCardEffect(card, user, enemy);
        }
        for (Card card : enemyCards) {
            applyCardEffect(card, enemy, user);
        }

        return user.getResource().get("HP") <= 0 || enemy.getResource().get("HP") <= 0;
    }

    private void applyCardEffect(Card card, Fighter caster, Fighter target) {
        Map<String, List<Integer>> effects = card.getCardInform();
        for (Map.Entry<String, List<Integer>> entry : effects.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue().get(0);
            int targetType = entry.getValue().get(1);

            if (targetType == 0) {
                // caster에게 효과 적용
                int newValue = caster.getResource().getOrDefault(key, 0) + value;
                caster.getResource().put(key, newValue);
            } else {
                // target에게 효과 적용
                int newValue = target.getResource().getOrDefault(key, 0) - value;
                target.getResource().put(key, newValue);
            }
        }
    }

    @Override
    public void endStage(Fighter user) {
        System.out.println("스테이지가 종료되었습니다. 보상을 받습니다.");
        Card rewardCard = getRandomCard();
        user.getreward(rewardCard);
        System.out.println("보상으로 받은 카드: " + rewardCard.getCardInform());
    }

    private Card getRandomCard() {
        List<Card> cardTypes = Arrays.asList(
                new AttackCard(),
                new DefenseCard(),
                new HealCard(),
                new AttackCard(20, 1),
                new DefenseCard(8, 0),
                new HealCard(15, 0)
        );
        Random random = new Random();
        return cardTypes.get(random.nextInt(cardTypes.size()));
    }
}
