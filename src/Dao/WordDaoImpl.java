package Dao;

import Entity.Word;
import Utils.DBUtilImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordDaoImpl implements WordDao {
    @Override
    public boolean SearchWord(Word word) {
        boolean flag = false;

        String sql = "select * from student where name= ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtilImpl dbUtilImpl = new DBUtilImpl();

        try {

            conn = dbUtilImpl.getConnection();

            pst = conn.prepareStatement(sql);
            //创建prepareStatement，进行预编译sql语句
            pst.setString(1, word.getCharacter());
            //占位

            rs = pst.executeQuery();

            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null && pst != null && rs != null) {
                dbUtilImpl.close(conn, pst, rs);
            }
        }

        return flag;
    }

    @Override
    public String UrlDBSearch(Word word) {

        String urlDB = "";

        String sql = "select password from student where name= ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtilImpl dbUtilImpl = new DBUtilImpl();

        try {

            conn = dbUtilImpl.getConnection();

            pst = conn.prepareStatement(sql);
            //创建prepareStatement，进行预编译sql语句
            pst.setString(1, word.getCharacter());
            //占位

            rs = pst.executeQuery();

            if (rs.next()) {
                urlDB = rs.getString("password");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return urlDB;
    }

    @Override
    public boolean UpDate(Word word) {
        boolean flag = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int index = 0;
        DBUtilImpl dbUtilImpl = new DBUtilImpl();
        String sql = "insert into student (name,password) values (?,?)";

        try {
            connection = dbUtilImpl.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, word.getCharacter());
            preparedStatement.setString(2, word.getUrlDB());
            index = preparedStatement.executeUpdate();

            if (index != 0) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtilImpl.close(connection, preparedStatement);
        }
        return flag;
    }


}
