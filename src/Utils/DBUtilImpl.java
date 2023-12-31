package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilImpl {

    private static DataSource ds = null;//存储数据源对象

    public static DataSource getDataSource() {//从C3P0连接池获取连接

        if (ds == null) {
            ds = new ComboPooledDataSource();
            System.out.println("c3p0连接池");
        }
        return ds;

    }


    public Connection getConnection() {//从连接池获取连接

        Connection connection = null;
        try {
            connection = getDataSource().getConnection();
            if (connection != null) {
                System.out.println("在连接池拿到连接");
                return connection;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void close(Connection connection, Statement statement, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (statement != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void close(Connection connection, Statement statement) {

        if (statement != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
