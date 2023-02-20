import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Car> list = new LinkedList<>();
    private static int action, numberOfSeats;
    private static String brand, model, color, bodyType;
    private static double engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm, trailerLength, maxLoadCapacity, fare, accelerationUpTo100KmPerHour;
    private static boolean winterTiresOn;

    public static void main(String[] args) {
        System.out.println("Мелехин Михаил Тимофеевич");
        System.out.println("Группа РИБО-01-21");

        while (true) {
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1 -- Создать транспорт");
            System.out.println("2 -- Удалить транспорт");
            System.out.println("3 -- Просмотреть весь транспорт");
            System.out.println("0 -- Выход");
            try {
                action = Integer.parseInt(scan());
                if (action == 0) {
                    break;
                }
                switch (action) {
                    case 1:
                        addTransport();
                        break;
                    case 2:
                        deleteTransport();
                        break;
                    case 3:
                        showAllTransport();
                        break;
                    default:
                        System.out.println("Необходимо ввести целое число от 0 до 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число от 0 до 3");
            }
        }
    }

    public static void addTransport() {
        while (true) {
            System.out.println();
            System.out.println("Выберите тип транспорта:");
            System.out.println("1 -- Легковой автомобиль");
            System.out.println("2 -- Автобус");
            System.out.println("3 -- Грузовик");
            System.out.println("0 -- Назад");
            try {
                action = Integer.parseInt(scan());
                if (action == 0) {
                    return;
                }
                switch (action) {
                    case 1:
                        list.add(createPassengerCar());
                        System.out.println("Автомобиль успешно добавлен!");
                        return;
                    case 2:
                        list.add(createBus());
                        System.out.println("Автобус успешно добавлен!");
                        return;
                    case 3:
                        list.add(createTruck());
                        System.out.println("Грузовик успешно добавлен!");
                        return;
                    default:
                        System.out.println("Необходимо ввести целое число от 0 до 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число от 0 до 3");
            }
        }
    }

    public static void deleteTransport() {
        while (true) {
            System.out.println();
            if (list.isEmpty()){
                System.out.println("Транспорта нет.");
                return;
            }
            System.out.println("Выберите транспорт, который хотите удалить (введите число):");
            int a = 1;
            for (Car car : list) {
                System.out.println(a + " -- " + car);
                a++;
            }
            try {
                action = Integer.parseInt(scan());
                if (action < 0 || action > list.size()) {
                    System.out.println("Нужно ввести целое число от 0 до " + list.size());
                    continue;
                }
                list.remove(action - 1);
                System.out.println("Транспорт успешно удален.");
                return;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число от 0 до " + list.size());
            }
        }
    }

    public static void showAllTransport() {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("Транспорта нет.");
            return;
        }
        for (Car car : list) {
            System.out.println(car);
        }
    }

    private static void createCar() {

        while (true) {
            System.out.println();
            System.out.println("Введите название бренда:");
            brand = scan();
            if (brand.isEmpty() || brand.isBlank()) {
                System.out.println("Поле бренд должно быть заполнено.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Введите название модели:");
            model = scan();
            if (model.isEmpty() || model.isBlank()) {
                System.out.println("Поле модель должно быть заполнено.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Введите цвет:");
            color = scan();
            if (color.isEmpty() || color.isBlank()) {
                System.out.println("Поле цвет должно быть заполнено.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println();
            System.out.println("Введите объем двигателя (в литрах):");
            try {
                engineCapacity = Double.parseDouble(scan());
                if (engineCapacity <= 0) {
                    System.out.println("Объем двигателя должен быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
        while (true) {
            System.out.println();
            System.out.println("Введите объем топливного бака (в литрах):");
            try {
                maxVolumeOfTheTank = Double.parseDouble(scan());
                if (maxVolumeOfTheTank <= 0) {
                    System.out.println("Объем топливного бака должен быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
        while (true) {
            System.out.println();
            System.out.println("Введите расход топлива за 1 км (в литрах):");
            try {
                fuelConsumptionPerKm = Double.parseDouble(scan());
                if (fuelConsumptionPerKm <= 0) {
                    System.out.println("Расход топлива за 1 км должен быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
    }

    public static PassengerCar createPassengerCar() {
        createCar();
        while (true) {
            System.out.println();
            System.out.println("Укажите время разгона до 100 км/ч (в секундах):");
            try {
                accelerationUpTo100KmPerHour = Double.parseDouble(scan());
                if (accelerationUpTo100KmPerHour <= 0) {
                    System.out.println("Время разгона до 100 км/ч должно быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
        while (true) {
            System.out.println();
            System.out.println("Какая резина надета? (введите число):");
            System.out.println("1 -- Летняя");
            System.out.println("2 -- Зимняя");
            try {
                action = Integer.parseInt(scan());
                if (action == 1) {
                    winterTiresOn = false;
                    break;
                } else if (action == 2) {
                    winterTiresOn = true;
                    break;
                } else {
                    System.out.println("Необходимо ввести целое число от 1 до 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести целое число от 1 до 2");
            }
        }
        while (true) {
            System.out.println();
            System.out.println("Введите тип кузова (седан, хэтч-бэк и тд.):");
            bodyType = scan();
            if (bodyType.isEmpty() || bodyType.isBlank()) {
                System.out.println("Поле тип кузова должно быть заполнено.");
                continue;
            }
            break;
        }
        return new PassengerCar(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm, accelerationUpTo100KmPerHour, winterTiresOn, bodyType);
    }

    public static Bus createBus() {
        createCar();
        while (true) {
            System.out.println();
            System.out.println("Введите кол-во мест:");
            try {
                numberOfSeats = Integer.parseInt(scan());
                if (numberOfSeats <= 0) {
                    System.out.println("Кол-во мест должно быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести целое число.");
            }
        }
        while (true) {
            System.out.println();
            System.out.println("Укажите плату за проезд (в рублях):");
            try {
                fare = Double.parseDouble(scan());
                if (fare < 0) {
                    System.out.println("Плата за проезд не может быть отрицательной.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
        return new Bus(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm, numberOfSeats, fare);
    }

    public static Truck createTruck() {
        createCar();
        while (true) {
            System.out.println();
            System.out.println("Укажите длину кузова (в метрах):");
            try {
                trailerLength = Double.parseDouble(scan());
                if (trailerLength <= 0) {
                    System.out.println("Длина кузова должна быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
        while (true) {
            System.out.println();
            System.out.println("Введите максимальную грузоподъемность (в кг.):");
            try {
                maxLoadCapacity = Double.parseDouble(scan());
                if (maxLoadCapacity <= 0) {
                    System.out.println("Грузоподъемность должна быть больше нуля.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат! Нужно ввести число.");
            }
        }
        return new Truck(brand, model, color, engineCapacity, maxVolumeOfTheTank, fuelConsumptionPerKm, trailerLength, maxLoadCapacity);
    }

    public static String scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}