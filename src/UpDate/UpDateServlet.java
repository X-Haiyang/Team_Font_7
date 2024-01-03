package UpDate;

import Entity.Word;
import Search.SearchManagement;
import Search.SearchService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Update", value = "/Update")
public class UpDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String character = request.getParameter("character");
        if (character == null) {
            character = "";
        }
        String urlDB = request.getParameter("urlDB");
        if (urlDB == null) {
            urlDB = "";
        }

        RequestDispatcher dispatcher = null;
        SearchService sm = new SearchManagement();

        Word word = new Word();
        word.setCharacter(character);
        word.setUrlDB(urlDB);

        if (sm.UpDate(word)) {//成功
            dispatcher = getServletContext().getRequestDispatcher("/UpDate.jsp");
        } else {//失败
            request.setAttribute("log", "err");
            dispatcher = getServletContext().getRequestDispatcher("/UpDate.jsp");
        }
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
