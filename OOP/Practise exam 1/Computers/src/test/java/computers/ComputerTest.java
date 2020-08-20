package computers;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {

    private Computer testComp;

    @Before
    public void setTestComp() {
         this.testComp = new Computer("pravec");
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkIfNullNameThrowsIAE() {
        Computer computer = new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfNolNameThrowsIAE() {
        Computer computer = new Computer("");
    }

    @Test
    public void constructorShouldSetCorrectName() {
        Computer computer = new Computer("vasko");
        assertEquals("vasko", computer.getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIfUnmodifiableListIsUnmodifiable() {
        List<?> testList = testComp.getParts();
        testList.remove(1);
    }

    @Test
    public void testIfUnmodifiableListIsNotNull(){
        assertNotNull(testComp.getParts());
    }

    @Test
    public void testIfTotalPriceReturnsZero(){
        double testPrice = testComp.getTotalPrice();
        assertEquals(0.00,testPrice,0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfAddNullPartThrowsIAE(){
        testComp.addPart(null);
    }

    @Test()
    public void testIfAddPartWorks(){
        testComp.addPart(new Part("GPU",5));
        assertEquals(1, testComp.getParts().size());
    }

    @Test
    public void testIfSumIsCorrect(){
        testComp.addPart(new Part("CPU", 12));
        testComp.addPart(new Part("CPU", 12));
        assertEquals(24,testComp.getTotalPrice(),0.00);
    }

    @Test
    public void testIfRemovePartWorks(){
        Part gosho = new Part("fdds",123);
        assertFalse(testComp.removePart(gosho));
        testComp.addPart(gosho);
        assertTrue(testComp.removePart(gosho));
    }

    @Test
    public void testGetPartReturnsNull(){
        assertNull(testComp.getPart("vanko"));
    }

    @Test
    public void testGetPartReturnsNonNull(){
        Part asd = new Part("asd", 123);
        testComp.addPart(asd);
        assertNotNull(testComp.getPart("asd"));
    }

}