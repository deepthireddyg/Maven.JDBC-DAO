package daos;

import junit.framework.TestCase;
import models.Car;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import java.util.Set;

public class DAOCarsTest extends TestCase {

    public void testFindById() throws SQLException {
        String expectedMake="Toyota";
        String expectedModel="Camry";
        String expectedYear="2015";
        String expectedColor="Red";
        String expectedVin="Klm34rdeg";
        //When
        DAOCars objCar= new DAOCars();
        Car objCar1= objCar.findById(1);

    }
@Test
    public void testFindAll() {

        int expectedCount=7;
        DAOCars objCars=new DAOCars();
        Set actualCars=objCars.findAll();
        Assert.assertEquals(expectedCount,actualCars.size());
    }

   @Test
    public void testCreate() {
            Car objCar=new Car();

            objCar.setMake("Toyota");
            objCar.setModel("Corolla");
            objCar.setColor("black");
            objCar.setYear("2022");
            objCar.setVin("Prtdugh");

            //when
            DAOCars objCar1=new DAOCars();
            Boolean actual= objCar1.create(objCar);
            Assert.assertTrue(actual);

        }

    @Test

    public void testUpdate() {
        Car objCar = new Car();
        objCar.setMake("toyotaTest");
        objCar.setModel("carola");
        objCar.setYear("2016");
        objCar.setColor("Pink");
        objCar.setVin("Prew3ig");
        objCar.setId(6);
        //when
        DAOCars objCars = new DAOCars();
        Boolean actual = objCars.update(objCar);
        Assert.assertTrue(actual);

    }


@Test
    public void testDelete() {
            DAOCars objCars=new DAOCars();
            //When
            Boolean actual= objCars.delete(8);
            //Then
            Assert.assertTrue(actual);

        }

}