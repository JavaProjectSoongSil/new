package Item;

import java.util.Map;

public abstract  class Item implements ItemInter {
    Map<String,Integer> itemAbility;//자신에게만 효과

    @Override
    public void showItem() {
        /*Set<String> keySet = itemAbility.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + resource.get(key));
        }*/
        System.out.println("show information");
    }

    @Override
    public Map<String, Integer> getItemInform() {
        return itemAbility;
    }
}