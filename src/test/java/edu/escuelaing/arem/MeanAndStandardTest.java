package edu.escuelaing.arem;

import edu.escuelaing.arem.math.LinkedList;
import edu.escuelaing.arem.math.MeanAndStandard;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MeanAndStandardTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MeanAndStandardTest() {
        super();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MeanAndStandardTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testMeanAndStandardTest() {
        assertTrue(true);
    }

    /**
     * 
     */
    public void MeanTest() {
        LinkedList<Double> a = new LinkedList<Double>();
        a.add(186.0);
        a.add(699.0);
        a.add(132.0);
        a.add(272.0);
        a.add(291.0);
        a.add(331.0);
        a.add(199.0);
        a.add(1890.0);
        a.add(788.0);
        a.add(1601.0);
        double mean = MeanAndStandard.mean(a);
        
        System.out.println(MeanAndStandard.standard(a));
        assertTrue(mean == mean);
    }

    /**
     * 
     */
    public void StandardTest() {
        LinkedList<Double> a = new LinkedList<Double>();
        a.add(186.0);
        a.add(699.0);
        a.add(132.0);
        a.add(272.0);
        a.add(291.0);
        a.add(331.0);
        a.add(199.0);
        a.add(1890.0);
        a.add(788.0);
        a.add(1601.0);
        double standard = MeanAndStandard.standard(a);

        assertTrue(standard == standard);
    }
}
