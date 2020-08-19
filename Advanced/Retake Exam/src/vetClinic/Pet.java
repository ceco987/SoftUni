package vetClinic;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.setAge(age);
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)%n", this.name,
                this.age,
                this.owner);
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) this.age = age;
    }

}
