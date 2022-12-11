package daos;



import java.sql.SQLException;
import java.sql.*;
import com.mysql.jdbc.Driver;


    public class ConnectionFactory {
        public static final String url = "jdbc:mysql://localhost:3306/Automobiles?autoReconnect=true&useSSL=false";
        public static final String uname = "deepthi";
        public static final String password = "SaanviAkshaj@789";



        public static Connection getConnection() {
            try {
                DriverManager.registerDriver(new Driver());
                System.out.println("test");
                return DriverManager.getConnection(url, uname, password);
            } catch (SQLException ex) {
                throw new RuntimeException("Error connecting to the database Noooo", ex);
            }
        }

        public static void main(String[] args) {
            Connection connection = ConnectionFactory.getConnection();
        }


    }


