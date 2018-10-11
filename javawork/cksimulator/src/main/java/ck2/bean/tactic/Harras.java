package ck2.bean.tactic;

public class Harras implements Tactic {

    String name = "harass_tactic";
    int duration = 18;
    String type = "Harass";
    String phase = "Skirmish";
    Triggerable[] eligibilitys = { () -> false, () -> true };
    int weight = 3;

    @Override
    public boolean trigger() {
        Triggerable[] eligibilitys = { () -> false };
        return Tactic.trigger(eligibilitys);
    }

}
