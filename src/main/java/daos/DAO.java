package daos;

import models.Car;

import java.sql.SQLException;
import java.util.Set;

public interface DAO {

        public Car findById(int id) throws SQLException;
        Set<Car> findAll();
        public Boolean update(Car dto);
        public Boolean create(Car dto);
        public Boolean delete(int id);
    }


