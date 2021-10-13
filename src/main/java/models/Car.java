package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//shift+alt+click

@Getter
@Setter
//@Builder
@ToString
public class Car {

    String address;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;
    String doors;
    String seats;
    String carClass;
    String fuelConsumption;
    String carRegNumber;
    String price;
    String distanceIncluded;
    String typeFeature;
    String about;

    public Car withFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car withAddress(String address) {
        this.address = address;
        return this;
    }

    public Car withMake(String make) {
        this.make = make;
        return this;
    }

    public Car withModel(String model) {
        this.model = model;
        return this;
    }

    public Car withYear(String year) {
        this.year = year;
        return this;
    }

    public Car withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car withFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car withGear(String gear) {
        this.gear = gear;
        return this;
    }

    public Car withwD(String wD) {
        this.wD = wD;
        return this;
    }

    public Car withDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car withSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car withCarClass(String carClass) {
        this.carClass = carClass;
        return this;
    }

    public Car withCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
        return this;
    }

    public Car withPrice(String price) {
        this.price = price;
        return this;
    }

    public Car withDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public Car withTypeFeature(String typeFeature) {
        this.typeFeature = typeFeature;
        return this;
    }

    public Car withAbout(String about) {
        this.about = about;
        return this;
    }
}
