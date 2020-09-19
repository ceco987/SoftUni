package Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> elements;
    private int index;

    public ListyIterator(String... values) {
        this.elements = Arrays.asList(values);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index< elements.size()-1;
            }

            @Override
            public String next() {
                return elements.get(this.index++);
            }
        };
    }

    public boolean move() {
        if (!this.hasNext()){
            return false;
        }
        this.index++;
        return true;
    }

    public boolean hasNext() {
        return this.index<this.elements.size()-1;
    }

    public String print() {
        checkForErrors(this.elements);
        return this.elements.get(this.index);
    }

    public String printAll(){
        checkForErrors(this.elements);
        String[] output = this.elements.stream().toArray(String[]::new);
        return String.join(" ",output);
    }

    private void checkForErrors(List<String> list){
        if (list.size()==0){
            throw new UnsupportedOperationException("Invalid Operation!");
        }
    }

}
