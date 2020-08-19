package vetClinic;

import java.util.LinkedList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public void add(Pet pet) {
        boolean condition = checkCondition(pet);
        if (capacity > 0 &&condition) this.data.add(pet);
        capacity -= 1;
    }

    private boolean checkCondition(Pet pet) {
        for (Pet domat : this.data) {
            if (domat.getName().equals(pet.getName())&&domat.getOwner().equals(pet.getOwner())) return false;
        }
        return true;
    }

    public boolean remove(String name) {
        Pet removedPet = null;
        for (Pet domat : this.data) {
            if (domat.getName().equals(name)){
                removedPet=domat;
            }
        }
        boolean removed = this.data.remove(removedPet);
        if(removed) capacity += 1;
        return removed;
    }

    public Pet getPet(String name, String owner) {
        Pet bestPet = null;
        for (Pet domat : this.data) {
            if (domat.getName().equals(name)&&domat.getOwner().equals(owner)) {
                bestPet=domat;
            }
        }
        return bestPet;
    }

    public Pet getOldestPet() {
        int maxAge = Integer.MIN_VALUE;
        Pet maxPet = null;
        for (Pet domat : this.data) {
            if (domat.getAge()>maxAge){
                maxAge=domat.getAge();
                maxPet=domat;
            }
        }
        return maxPet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder("This clinic has the following patients:\n");
       this.data.stream().forEach(e->{
           result.append(e.getName()).append(" ").append(e.getOwner()).append(System.lineSeparator());
       });
        return result.toString();
    }
}
