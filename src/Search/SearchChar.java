package Search;


import Entity.Word;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "search", value = "/search")
public class SearchChar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String character = request.getParameter("character");
        if (character == null) {
            character = "";
        }


        RequestDispatcher dispatcher = null;
//        LoginManagement lm=new LoginManagement();

        SearchManagement sm = new SearchManagement();
//---------------------------------------------------------------
        // 1.通过请求对象向Tomcat所要当前网站的全局作用域对象
        ServletContext application = request.getServletContext();
//---------------------------------------------------------------

        Word word = new Word();
        word.setCharacter(character);


        if (sm.SearchWord(word)) {
            request.setAttribute("log", "ok");

//-------------------------------------------------------
            // 2.将数据添加到全局作用域对象，作为共享数据
            application.setAttribute("character", character);
//-------------------------------------------------------
            dispatcher = getServletContext().getRequestDispatcher("/DisplayFont.jsp");
        } else {
            request.setAttribute("log", "err");
            dispatcher = getServletContext().getRequestDispatcher("/FontMain.jsp");
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}