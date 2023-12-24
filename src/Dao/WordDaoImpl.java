package Dao;

import Entity.Word;
import Utils.DBUtilImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WordDaoImpl implements WordDao{
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
}
