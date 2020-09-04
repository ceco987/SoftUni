package GenericBox;

public class Box <T>{
    private T test;

    public void setTest(T test){
        this.test = test;
    }

    @Override
    public String toString(){
        return test.getClass().getName() + ": "+test.toString();
    }
}
