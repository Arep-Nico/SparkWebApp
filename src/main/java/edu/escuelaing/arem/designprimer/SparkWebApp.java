package edu.escuelaing.arem.designprimer;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import edu.escuelaing.arem.math.MeanAndStandard;
import edu.escuelaing.arem.math.LinkedList;

/**
* @author Nicolas Cardenas
* @version: 30/01/2019
*/
public class SparkWebApp {

    /**
     * Funcion principal del proyecto
     * @param args argumentos de la clase
     */
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> helloPage(req, res));
        get("/hello/:name", (req, res) -> {
            return "Hello: " + req.params(":name");
        });
        get("/calc", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }


    /**
     * @return retorna un puerto disponible para correr la aplicacion
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    /**
     * Pagina de bienvenida
     * 
     * @return retorna un documento HTML para renderizar
     */
    private static String helloPage(Request req, Response res) {
        String pageContent = "<!DOCTYPE html>" + "<html>" + "<body>" 
                + "<h1>Hello Heroku</h1>"
                + "<form action=\"/calc\">" 
                + "press the button to go to math module: "
                + "<input type=\"submit\" value=\"Submit\">" 
                + "</form>"
                + "</body>" + "</html>";
        return pageContent;
    }

    /**
     * Pagina de toma de datos para encontrar la media y la desviacion estandar
     * 
     * @return retorna un documento HTML para renderizar
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent = "<!DOCTYPE html>" + "<html>" + "<body>" 
                + "<center>"
                + "<h2>Data Inputs</h2>"
                + "<form action=\"/results\">" 
                + "  <input type=\"text\" name=\"data\" placeholder=\"Ej. 1,2,3\">" + "<br/><br/>"
                + "  <input type=\"submit\" value=\"Submit\">" + "</form>"
                + "</center>"
                + "</body>" + "</html>";
        return pageContent;
    }

    /**
     * Pagina de resultados de los calculos de la pagina /calc
     * @return retorna un documento HTML para renderizar
     */
    private static String resultsPage(Request req, Response res) {
        String a[] = req.queryParams("data").split(",");
        LinkedList<Double> dataList = new LinkedList<Double>();
        for (String string : a) {
            dataList.add(Double.parseDouble(string));
        }

        double mean = MeanAndStandard.mean(dataList);
        double standard = MeanAndStandard.standard(dataList);

        String pageContent = "<!DOCTYPE html>" + "<html>" + "<body>" 
                + "<center>" + "<h2>Results</h2>"
                + "<h3> Mean: " + mean + "</h3>"
                + "<h3> Standard: " + standard + "</h3>"
                + "</center>" + "</body>" + "</html>";
        return pageContent;
    }
}