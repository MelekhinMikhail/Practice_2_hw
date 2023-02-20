public class Bus extends Car {

    private int numberOfSeats;
    private double fare;
    private int currentCountOfPassengers;

    public Bus(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm) {
        super(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm);
    }

    public Bus(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm, int numberOfSeats, double fare) {
        super(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm);
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Кол-во мест должно быть больше нуля.");
        } else {
            this.numberOfSeats = numberOfSeats;
        }
        if (fare < 0) {
            throw new IllegalArgumentException("Плата за проезд не может быть отрицательной.");
        } else {
            this.fare = fare;
        }
        currentCountOfPassengers = 0;
    }

    public void addPassengers(int countOfPassengers) {
        if (countOfPassengers <= 0) {
            throw new IllegalArgumentException("Количество пассажиров должно быть больше нуля.");
        } else if (countOfPassengers > (numberOfSeats - currentCountOfPassengers)) {
            System.out.println("Автобус не может вместить столько пасссажиров.");
            System.out.println("Свободно мест: " + (numberOfSeats - currentCountOfPassengers));
        } else {
            currentCountOfPassengers += countOfPassengers;
        }
    }

    public void removePassengers(int countOfPassengers) {
        if (countOfPassengers <= 0) {
            throw new IllegalArgumentException("Количество пассажиров должно быть больше нуля.");
        } else if (countOfPassengers > currentCountOfPassengers) {
            System.out.println("В автобусе нет столько пассажиров.");
            System.out.println("Пассажиров в автобусе: " + currentCountOfPassengers);
        } else {
            currentCountOfPassengers -= countOfPassengers;
        }
    }

    @Override
    public String toString() {
        return "Автобус " + getBrand() + " " + getModel() + ", Цвет: " + getColor() + ", Объем двигателя: " + getEngineCapacity() + "л., " +
                "Объем топливного бака: " + getMaxVolumeOfTheTank() + " л., Расход топлива за 1 км.: " + getFuelConsumptionPerKm() + "л., " +
                "Количество мест: " + numberOfSeats + ", Пассажиров в салоне: " + currentCountOfPassengers + ", Плата за проезд: " + fare + "руб.";
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Кол-во мест должно быть больше нуля.");
        } else {
            this.numberOfSeats = numberOfSeats;
        }
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        if (fare < 0) {
            throw new IllegalArgumentException("Плата за проезд не может быть отрицательной.");
        } else {
            this.fare = fare;
        }
    }

    public int getCurrentCountOfPassengers() {
        return currentCountOfPassengers;
    }

    public void setCurrentCountOfPassengers(int currentCountOfPassengers) {
        if (currentCountOfPassengers <= 0) {
            throw new IllegalArgumentException("Текущее кол-во пассажиров должно быть больше нуля.");
        } else if (currentCountOfPassengers > numberOfSeats) {
            System.out.println("Текущее кол-во пассажиров не должно превышать общее кол-во мест.");
        } else {
            this.currentCountOfPassengers = currentCountOfPassengers;
        }
    }
}
