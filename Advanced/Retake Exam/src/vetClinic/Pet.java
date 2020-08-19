package vetClinic;

public class Pet {
    private String name;
    private String owner;
    private int age;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.owner = owner;
        if (age > 0) {
            this.age = age;
        }
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
}
