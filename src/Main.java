import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int measure;
        do {
            System.out.println("Выберите что переводить: 1 - расстояние, 2 - масса");
            measure = console.nextInt();
            if (measure != 1 && measure != 2) System.out.println("Физическая величина выбрана неверно");
        } while (measure != 1 && measure != 2);
        int unit;
        do {
            if (measure == 1) {
                System.out.println("Выберите единицу измерения: 1 - метр, 2 - международная миля, 3 - ярд, 4 - международный фут");
            } else {
                System.out.println("Выберите единицу измерения: 1 - грамм, 2 - пуд, 3 - унция, 4 - английский фунт");
            }
            unit = console.nextInt();
            if (unit < 1 || unit > 4) System.out.println("Единица измерения выбрана неверно");
        } while (unit < 1 || unit > 4);

        System.out.println("Введите число");
        int quantity = console.nextInt();

        double first;
        double second;
        double third;
        double fourth;

        String firstLabel = (measure == 1) ?  "Метры" : "Граммы";
        String secondLabel = (measure == 1) ?  "Международные мили" : "Пуды";
        String thirdLabel = (measure == 1) ?  "Ярды" : "Унции";
        String fourthLabel = (measure == 1) ?  "Международные футы" : "Английские фунты";

        switch (unit) {
            case  (1):
                first = quantity;
                second = (measure == 1) ?  first / 1609.344D : first / 16380.4964D;
                third = (measure == 1) ?  first / 0.9144D : first / 28.349523125D;
                fourth = (measure == 1) ?  first / 0.3048D : first / 453.59237D;
                break;
            case (2):
                second = quantity;
                first = (measure == 1) ?  second * 1609.344D : second * 16380.4964D;
                third = (measure == 1) ?  first / 0.9144D : first / 28.349523125D;
                fourth = (measure == 1) ?  first / 0.3048D : first / 453.59237D;
                break;
            case (3):
                third = quantity;
                first = (measure == 1) ?  third * 0.9144D : third * 28.349523125D;
                second = (measure == 1) ?  first / 1609.344D : first / 16380.4964D;
                fourth = (measure == 1) ?  first / 0.3048D : first / 453.59237D;
                break;
            case (4):
                fourth = quantity;
                first = (measure == 1) ?  fourth / 0.3048D : fourth / 453.59237D;
                second = (measure == 1) ?  first / 1609.344D : first / 16380.4964D;
                third = (measure == 1) ?  first / 0.9144D : first / 28.349523125D;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + unit);
        }
        System.out.println("Результат:");
        DecimalFormat df = new DecimalFormat("#.########");
        System.out.println( firstLabel + ": " + df.format(first));
        System.out.println(secondLabel + ": " + df.format(second));
        System.out.println(thirdLabel + ": " + df.format(third));
        System.out.println(fourthLabel + ": " + df.format(fourth));

    }
}