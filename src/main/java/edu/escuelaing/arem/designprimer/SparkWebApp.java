package edu.escuelaing.arem.designprimer;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import edu.escuelaing.arem.math.MeanAndStandard;
import edu.escuelaing.arem.math.LinkedList;

/**
 * SparkWebApp
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> helloPage(req, res));
        get("/hello/:name", (req, res) -> {
            return "Hello: " + req.params(":name");
        });
        get("/calc", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

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