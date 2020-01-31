package edu.escuelaing.arem;

import edu.escuelaing.arem.math.LinkedList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LinkedListTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest() {
        super();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LinkedListTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testLinkedListTest() {
        assertTrue(true);
    }

    /**
     * Crear una lista de objetos
     */
    public void CrearLinkedList() {
        LinkedList<Object> l = new LinkedList<Object>();
        assertTrue(l.size() == 0);
    }

    /**
     * 
     */
    public void CrearYargregarNodo() {
        int Vtest = 10;
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(Vtest);
        assertTrue(l.get(0) == Vtest);
    }

    /*
     * @Test public void CrearYargregarNodoIndex(){ // no deberia pasar, si falla la
     * prueba es correcta int Vtest =10; LinkedList<Integer> l = new
     * LinkedList<Integer>(); l.add(10, Vtest); }
     */
    public void clearLinkedList() {
        int Vtest1 = 10;
        int Vtest2 = 11;
        int Vtest3 = 12;
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(Vtest1);
        l.add(Vtest2);
        l.add(Vtest3);
        l.clear();
        assertTrue(l.size() == 0);
    }
}
