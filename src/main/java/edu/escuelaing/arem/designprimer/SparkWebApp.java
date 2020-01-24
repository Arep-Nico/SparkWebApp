package edu.escuelaing.arem.designprimer;

import static spark.Spark.*;

/**
 * SparkWebApp
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> "Hello Heroku");
        get("/hello/:name", (req, res) -> {
            return "Hello: " + req.params(":name");
        });
        get("/calc", (req, res) -> {
            return "";
        }));
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}