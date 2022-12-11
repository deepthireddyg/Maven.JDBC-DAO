package daos;



import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    public class DAOCars implements DAO{

        public Car extractCarFromResultSet(ResultSet rs) throws SQLException{
            Car car = new Car();

            car.setId( rs.getInt("id") );
            car.setMake( rs.getString("make") );
            car.setModel( rs.getString("model") );
            car.setYear( rs.getString("year") );
            car.setColor( rs.getString("color") );
            car.setVin( rs.getString("vin") );

            return car;
        }

        public Car findById(int id) throws SQLException {
            Connection connection = ConnectionFactory.getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);

            rs.next();

            return null;

        }

        public Set<Car> findAll() {

            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement st = connection.prepareStatement("select * from car");
                ResultSet rs = st.executeQuery();

                Set cars=new HashSet();

                while(rs.next())
                {
                    Car car = extractCarFromResultSet(rs);
                    cars.add(car);
                }

                return cars;

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return null;
        }

        public Boolean create(Car dto) {
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement pst =connection.prepareStatement("INSERT INTO CAR(MAKE,MODEL,YEAR,COLOR,VIN) " +
                        "VALUES (?,?,?,?,?)");

                pst.setString(1, dto.getMake());
                pst.setString(2,dto.getModel());
                pst.setString(3,dto.getYear());
                pst.setString(4,dto.getColor());
                pst.setString(5,dto.getVin());

                int status=pst.executeUpdate();
                connection.close();
                if (status==1)return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }
        public Boolean update(Car dto)
        {
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement pst=connection.prepareStatement("UPDATE CAR SET MAKE=?,MODEL=?,YEAR=?,COLOR=?,VIN=? WHERE ID=?");

                pst.setString(1, dto.getMake());
                pst.setString(2, dto.getModel());
                pst.setString(3,dto.getYear());
                pst.setString(4,dto.getColor());
                pst.setString(5,dto.getVin());
                pst.setInt(6,dto.getId());
                int status=pst.executeUpdate();
                connection.close();
                if (status==1)return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }

        public Boolean delete(int id)
        {
            Connection connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement pst=connection.prepareStatement("DELETE FROM CAR WHERE ID=?");
                pst.setInt(1,id);
                int status=pst.executeUpdate();
                connection.close();
                if (status==1)return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }


    }



