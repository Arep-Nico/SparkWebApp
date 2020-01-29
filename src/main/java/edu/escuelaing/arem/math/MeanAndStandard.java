package edu.escuelaing.arem.math;

/* 
* @author Nicolas Cardenas
* @version: 22/01/2019
*/
public class MeanAndStandard {

    /**
     * Saca el promedio de los elementos de una lista
     * @param list elementos para hacer la operacion
     * @return la media aritmetica
     */
    public static double mean(LinkedList<Double> list) {
        double res = 0.0;
        for (double double1 : list) {
            res += double1;
        }
        return res / list.size();
    }

    /**
     * Saca la desviacion estandar de los elemetos
     * 
     * @param list elementos para hacer la operacion
     * @return desviacion estandar
     */
    public static double standard(LinkedList<Double> list) {
        double mean =  MeanAndStandard.mean(list);
        double sum = 0.0;
        for (Double double1 : list) {
            sum += Math.pow((double1 - mean), 2);
        }
        double div = sum / (list.size() - 1);
        return Math.sqrt(div);
    }
}