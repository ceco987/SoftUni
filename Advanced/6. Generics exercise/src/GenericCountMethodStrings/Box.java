package GenericCountMethodStrings;

public class Box<T extends Comparable<T>> implements Comparable<T> {
    private T item;

    public Box(T item){
        this.item = item;
    }

    @Override
    public int compareTo(T o) {
        return this.item.compareTo(o);
    }

    @Override
    public String toString(){
        return item.getClass().getName() + ": "+ item.toString();
    }
}
