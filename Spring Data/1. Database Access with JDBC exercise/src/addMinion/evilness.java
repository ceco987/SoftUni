package addMinion;

public enum evilness {
    GOOD("good"), BAD("bad"), EVIL("evil"), SUPER_EVIL("super evil");
    private String evilFactor;

    evilness(String evilFactor) {
        this.evilFactor = evilFactor;
    }

    public String evilFactor (){
        return this.evilFactor;
    }
}
