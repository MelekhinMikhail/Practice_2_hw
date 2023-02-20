public class Car {

    private final String brand;
    private final String model;
    private String color;
    private double engineCapacity;
    private double maxVolumeOfTheTank;
    private double currentVolumeOfTheTank;
    private double fuelConsumptionPerKm;

    public Car(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Объем двигателя должен быть положительным.");
        } else {
            this.engineCapacity = engineCapacity;
        }
        if (maxVolumeOfTheTank <= 0) {
            throw new IllegalArgumentException("Объем топливного бака должен быть положительным.");
        } else {
            this.maxVolumeOfTheTank = maxVolumeOfTheTank;
        }
        currentVolumeOfTheTank = 0;
        if (fuelConsumptionPerKm <= 0) {
            throw new IllegalArgumentException("Расход топлива на 1 километр должен быть положительным.");
        } else {
            this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        }
    }

    public void refuel(double fuel) {
        if (fuel < 0) {
            throw new IllegalArgumentException("Количество топлива не может быть отрицательным.");
        } else if (fuel > (maxVolumeOfTheTank - currentVolumeOfTheTank)) {
            throw new IllegalArgumentException("В баке нет столько места.");
        } else {
            currentVolumeOfTheTank += fuel;
            System.out.println("Транспорт успешно заправлен на " + fuel + "л.");
            System.out.println("Всего литров в баке: " + currentVolumeOfTheTank + "л.");
        }
    }

    public void drive(double kilometers) {
        if (kilometers <= 0) {
            throw new IllegalArgumentException("Километры должны быть больше нуля.");
        }
        if ((kilometers * fuelConsumptionPerKm) > currentVolumeOfTheTank) {
            System.out.println("Закончилось топливо... Транспорт проехал " + (currentVolumeOfTheTank / fuelConsumptionPerKm) + " км.");
            currentVolumeOfTheTank = 0;
        } else {
            System.out.println("Транспорт проехал " + kilometers + "км.");
            currentVolumeOfTheTank -= kilometers * fuelConsumptionPerKm;
            System.out.println("Текущее состояние топливного бака: " + currentVolumeOfTheTank + " л.");
        }
    }

    public void pumpUpWheels() {
        System.out.println("Колеса накачаны.");
    }

    @Override
    public String toString() {
        return "Транспорт " + brand + " " + model + ", Цвет: " + color + ", Объем двигателя: " + engineCapacity + "л., " +
                "Объем топливного бака: " + maxVolumeOfTheTank + " л., Расход топлива за 1 км.: " + fuelConsumptionPerKm + "л.";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Объем двигателя должен быть положительным.");
        } else {
            this.engineCapacity = engineCapacity;
        }
    }

    public double getMaxVolumeOfTheTank() {
        return maxVolumeOfTheTank;
    }

    public void setMaxVolumeOfTheTank(double maxVolumeOfTheTank) {
        if (maxVolumeOfTheTank <= 0) {
            throw new IllegalArgumentException("Объем топливного бака должен быть положительным.");
        } else {
            this.maxVolumeOfTheTank = maxVolumeOfTheTank;
        }
    }

    public double getCurrentVolumeOfTheTank() {
        return currentVolumeOfTheTank;
    }

    public void setCurrentVolumeOfTheTank(double currentVolumeOfTheTank) {
        if (currentVolumeOfTheTank < 0) {
            throw new IllegalArgumentException("Объем не может быть отрицатльным.");
        } else if (currentVolumeOfTheTank > maxVolumeOfTheTank) {
            throw new IllegalArgumentException("Указанный объем не должен превышать объем бака");
        } else {
            this.currentVolumeOfTheTank = currentVolumeOfTheTank;
        }
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        if (fuelConsumptionPerKm <= 0) {
            throw new IllegalArgumentException("Расход топлива на 1 километр должен быть положительным.");
        } else {
            this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        }
    }
}
