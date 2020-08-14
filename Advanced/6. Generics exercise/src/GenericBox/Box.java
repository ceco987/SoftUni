package GenericBox;

public class Box <T>{
    private T test;

    public void setTest(T test){
        this.test = test;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(test.getClass().toString().replaceAll("class ",""))
                .append(": ")
                .append(this.test);
        return output.toString();
    }
}
