import static org.junit.Assert.*;
import org.junit.Test;
public class Junit4AssertionTest {
    @Test
    public void testAssertOK(){
        String string1="Junit";
        String string2="Junit";

        //Assert statements
        assertEquals(string1,string2);
    }

    @Test
    public void testAssertNOK(){
        String string1="ABC";
        String string2="ABC";
        String string3="ABC";
        String string4="ABC";
        String string5=null;
        int variable1=1;
        int	variable2=2;
        int[] airethematicArrary1 = { 1, 2, 3 };
        int[] airethematicArrary2 = { 3, 2, 0 };

        //Assert statements
        assertEquals(string1,string2);
    }
}
