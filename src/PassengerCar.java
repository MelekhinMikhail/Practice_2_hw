public class PassengerCar extends Car {

    private double accelerationUpTo100KmPerHour;
    private boolean winterTiresOn;
    private String bodyType;

    public PassengerCar(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm) {
        super(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm);
    }

    public PassengerCar(String brand, String model, String color, double engineCapacity, double maxVolumeOfTheTank, double fuelConsumptionPerKm, double accelerationUpTo100KmPerHour, boolean winterTiresOn, String bodyType) {
        super(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm);
        if (accelerationUpTo100KmPerHour <= 0 ) {
            throw new IllegalArgumentException("Количество секунд разгона до 100 км/ч должно быть больше нуля.");
        } else {
            this.accelerationUpTo100KmPerHour = accelerationUpTo100KmPerHour;
        }
        this.winterTiresOn = winterTiresOn;
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Автомобиль " + getBrand() + " " + getModel() + ", Цвет: " + getColor() + ", Объем двигателя: " + getEngineCapacity() + "л., " +
                "Объем топливного бака: " + getMaxVolumeOfTheTank() + " л., Расход топлива за 1 км.: " + getFuelConsumptionPerKm() + "л., " +
                "Разгон до 100 км/ч: " + accelerationUpTo100KmPerHour + " с., Резина: " + ((winterTiresOn) ? "зимняя":"летняя") + ", " +
                "Тип кузова: " + bodyType;
    }

    public double getAccelerationUpTo100KmPerHour() {
        return accelerationUpTo100KmPerHour;
    }

    public void setAccelerationUpTo100KmPerHour(double accelerationUpTo100KmPerHour) {
        if (accelerationUpTo100KmPerHour <= 0 ) {
            throw new IllegalArgumentException("Количество секунд разгона до 100 км/ч должно быть больше нуля.");
        } else {
            this.accelerationUpTo100KmPerHour = accelerationUpTo100KmPerHour;
        }
    }

    public boolean isWinterTiresOn() {
        return winterTiresOn;
    }

    public void setWinterTiresOn(boolean winterTiresOn) {
        this.winterTiresOn = winterTiresOn;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
