package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void chheckIfTheConstructorIsWorking() throws OperationNotSupportedException {
        Integer[] expected = {1,2,3,6};
        Database testDB = new Database(1,2,3,6);
        assertEquals(expected, testDB.getElements());
        assertEquals(expected.length,testDB.getElements().length);

    }


}