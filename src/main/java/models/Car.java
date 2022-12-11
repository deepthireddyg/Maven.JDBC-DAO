package models;

public class Car {

        private Integer id;
        private String name;
        private String make;
        private String model;
        private String year;
        private String color;
        private String vin;

        public Car(Integer id, String name, String make, String model, String year, String color, String vin) {
            this.id = id;
            this.name = name;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.vin = vin;
        }

        public Car(String name, String make, String model, String year, String color, String vin) {
            this.name = name;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.vin = vin;
        }

        public Car() {

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

    }
