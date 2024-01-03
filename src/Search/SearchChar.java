package Search;


import Dao.WordDaoImpl;
import Entity.Word;
import jakarta.servlet.RequestDispatcher;
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

        WordDaoImpl wd = new WordDaoImpl();
        HttpSession session = request.getSession();//HttpSession对象可以用于存储和访问与用户会话相关的信息。
        String character = request.getParameter("character");//获取"character"的值
        if (character == null) {
            character = "";
        }


        RequestDispatcher dispatcher = null;//跳转页面

        SearchManagement sm = new SearchManagement();

        Word word = new Word();
        word.setCharacter(character);


        if (sm.SearchWord(word)) {
            request.setAttribute("log", "ok");
//-------------------------------------------------------
            session.setAttribute("character", character);

            String urlDB = wd.UrlDBSearch(word);//根据字查找数据库中的URL
            session.setAttribute("urlDB", urlDB);
//-------------------------------------------------------
            dispatcher = getServletContext().getRequestDispatcher("/DisplayFont.jsp");
        } else {
            request.setAttribute("log", "err");
            dispatcher = getServletContext().getRequestDispatcher("/FontMain.jsp");
        }
        dispatcher.forward(request, response);//跳转前端页面
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}