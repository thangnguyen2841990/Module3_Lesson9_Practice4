package com.codegym;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet", value = "/look-word")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello", "Xin chào");
        dictionary.put("Good bye", "Tạm biệt");
        dictionary.put("Dog", "Chó");
        dictionary.put("Cat", "Mèo");
        dictionary.put("Smile", "Nụ cười");
        dictionary.put("Play", "Chơi");
        String search = request.getParameter("inputNewWord");
        PrintWriter printWriter= response.getWriter();
        printWriter.println("<html>");
        String result = dictionary.get(search);
        if (result == null) {
            printWriter.println("Không có kết quả!");
        } else {
            printWriter.println("Từ "+ search +" có nghĩa là: "+ result);
        }
        printWriter.println("</html>");
    }
}
