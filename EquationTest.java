import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class Calculator
 */
@RunWith(JUnit4.class)
public class EquationTest
{
    //~ Public Methods ........................................................

    @Test
    public void testSolveEquation()
    {
        assertEquals( "checking that \"12435+34569-12345*10+50\" equals -76396 ",
                "-76396", Java.SolveEquation.solve("12435+34569-12345*10+50"));

        assertEquals( "checking that \"20+100*10*50\" equals 50020 ",
                "50020", Java.SolveEquation.solve("20+100*10*50"));

        assertEquals( "checking that \"2*2*2*2\" equals 16 ",
                "16", Java.SolveEquation.solve("2*2*2*2"));

        assertEquals( "checking that \"1+2+3+4+5\" equals 15 ",
                "15", Java.SolveEquation.solve("1+2+3+4+5"));

        assertEquals( "checking that \"2+2\" equals 4 ",
                "4", Java.SolveEquation.solve("2+2"));

        assertEquals( "checking that \"20+5-40+50-90*10\" equals -865 ",
                "-865", Java.SolveEquation.solve("20+5-40+50-90*10"));

        assertEquals( "checking that \"6*2\" equals 12 ",
                "12", Java.SolveEquation.solve("6*2"));
    }
}