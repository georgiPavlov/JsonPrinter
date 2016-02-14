import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by georgipavlov on 14.02.16.
 */
@WebServlet("/t")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //String json = request.getParameter("json");
        out.println("<html><body>" + "<h1>" + "hello world" + "</h1>" + "</body></html>");
        String uglyJSONString= "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":802,\"main\":\"Clouds\"," +
                "\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"base\":\"cmc stations\",\"main\":{" +
                "\"temp\":277.677,\"pressure\":1001.76,\"humidity\":87,\"temp_min\":277.677,\"temp_max\":277.677,\"sea_level" +
                "\":1011.76,\"grnd_level\":1001.76},\"wind\":{\"speed\":7.62,\"deg\":20.0009},\"clouds\":{\"all\":44},\"dt" +
                "\":1455467233,\"sys\":{\"message\":0.0055,\"country\":\"GB\"," +
                "\"sunrise\":1455434170,\"sunset\":1455470038},\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        response.getWriter().write(prettyJsonString);



    }
}
