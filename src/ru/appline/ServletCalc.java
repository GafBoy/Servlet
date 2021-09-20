package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.Results;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class ServletCalc extends HttpServlet {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);


        Double a = jobj.get("a").getAsDouble();
        Double b = jobj.get("b").getAsDouble();
        String math = jobj.get("math").getAsString();
        Double answer = 0.0;
if (math.equals("+")){
    answer = a + b;
}
        if (math.equals("-")){
            answer = a - b;
        }
        if (math.equals("*")){
            answer = a * b;
        }
        if (math.equals("/")){
            answer = a / b;
        }
Results results = new Results(answer);
        PrintWriter pw = response.getWriter();

        pw.print(gson.toJson(results));
    }
}