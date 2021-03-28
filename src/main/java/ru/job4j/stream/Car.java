package ru.job4j.stream;

public class Car {
    private String model;
    private int maxSpeed;
    private long price;
    private String city;
    private int power;

    static class Builder {
        private String model;
        private int maxSpeed;
        private long price;
        private String city;
        private int power;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildPrice(long price) {
            this.price = price;
            return this;
        }

        Builder buildCity(String city) {
            this.city = city;
            return this;
        }

        Builder buildPower(int power) {
            this.power = power;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.model = model;
            car.city = city;
            car.maxSpeed = maxSpeed;
            car.power = power;
            car.price = price;
            return car;
        }

    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", power=" + power +
                '}';
    }

    public static void main(String[] args) {
        Car car = new Builder().buildModel("BMW")
                .buildMaxSpeed(300)
                .buildPrice(4000000)
                .buildCity("Germany")
                .buildPower(500)
                .build();
        System.out.println(car);
    }
}
