package ck2.bean.tactic;

public interface Tactic {

    public static Tactic[] tacticArray = { new Harras() };

    public boolean trigger();

    static boolean trigger(Triggerable[] eligibilitys) {
        boolean resualt = false;
        for (Triggerable eligibility : eligibilitys) {
            resualt &= eligibility.trigger();
        }
        return resualt;
    }

}