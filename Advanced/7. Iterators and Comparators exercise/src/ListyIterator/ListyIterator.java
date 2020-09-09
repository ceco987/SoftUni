package ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int index;

    public ListyIterator(String... values) {
        this.elements = Arrays.asList(values);
    }

    public boolean move() {
        if (!this.hasNext()){
            return false;
        }
        this.index++;
        return true;
    }

    public boolean hasNext() {
        return this.index<this.elements.size();
    }

    public String print() {
        if (this.elements.size()==0){
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        return this.elements.get(this.index);
    }



}
