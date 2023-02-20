public class Truck extends Car {
    private double trailerLength;
    private double maxLoadCapacity;
    private double currentLoadCapacity;

    public Truck(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm) {
        super(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm);
    }

    public Truck(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm, double trailerLength, double loadCapacity) {
        super(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm);
        if (trailerLength <= 0) {
            throw new IllegalArgumentException("Длина прицепа должна быть больше нуля.");
        } else {
            this.trailerLength = trailerLength;
        }
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Грузоподъемность должна быть больше нуля.");
        } else {
            this.maxLoadCapacity = loadCapacity;
        }
        currentLoadCapacity = 0;
    }

    public void loadWeight(double kilograms) {
        if (kilograms <= 0) {
            throw new IllegalArgumentException("Вес груза должен быть больше нуля.");
        } else if (kilograms > (maxLoadCapacity - currentLoadCapacity)) {
            System.out.println("Недопустимый вес, грузовик перегружен.");
            System.out.println("Осталось места: " + (maxLoadCapacity - currentLoadCapacity) + " кг.");
        } else {
            currentLoadCapacity += kilograms;
            System.out.println("Груз добавлен, текущая загруженность грузовика: " + currentLoadCapacity + " кг.");
        }
    }

    public void unloadWeight(double kilograms) {
        if (kilograms <= 0) {
            throw new IllegalArgumentException("Вес груза должен быть больше нуля.");
        } else if (kilograms > currentLoadCapacity) {
            System.out.println("В грузовике нет столько груза.");
            System.out.println("Текущая загруженность грузовика: " + currentLoadCapacity + " кг.");
        } else {
            currentLoadCapacity -= kilograms;
            System.out.println("Груз выгружен, текущая загруженность грузовика: " + currentLoadCapacity + " кг.");
        }
    }

    @Override
    public String toString() {
        return "Грузовик " + getBrand() + " " + getModel() + ", Цвет: " + getColor() + ", Объем двигателя: " + getEngineCapacity() + "л., " +
                "Объем топливного бака: " + getMaxVolumeOfTheTank() + " л., Расход топлива за 1 км.: " + getFuelConsumptionPerKm() + "л., " +
                "Длина прицепа: " + trailerLength + " м., Грузоподъемность: " + maxLoadCapacity + " кг., Текущая загруженность: " + currentLoadCapacity + " кг.";
    }

    public double getTrailerLength() {
        return trailerLength;
    }

    public void setTrailerLength(double trailerLength) {
        if (trailerLength <= 0) {
            throw new IllegalArgumentException("Длина прицепа должна быть больше нуля.");
        } else {
            this.trailerLength = trailerLength;
        }
    }

    public double getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void setMaxLoadCapacity(double loadCapacity) {
        if (loadCapacity <= 0) {
            throw new IllegalArgumentException("Грузоподъемность должна быть больше нуля.");
        } else {
            this.maxLoadCapacity = loadCapacity;
        }
    }

    public double getCurrentLoadCapacity() {
        return currentLoadCapacity;
    }

    public void setCurrentLoadCapacity(double currentLoadCapacity) {
        if (currentLoadCapacity < 0) {
            throw new IllegalArgumentException("Текущая загруженность грузовика не может быть отрицательной.");
        } else if (currentLoadCapacity > maxLoadCapacity) {
            throw new IllegalArgumentException("Текущая загруженность грузовика не должна превышать максимальную грузоподъемность.");
        } else {
            this.currentLoadCapacity = currentLoadCapacity;
        }
    }
}
