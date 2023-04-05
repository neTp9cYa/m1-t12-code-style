import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.calculateDeposit();
    }

    double calculateComplexPercent(double amount, double yearRate, int yearCount) {
        double monthRate = yearRate / 12;
        int monthCount = 12 * yearCount;
        double resultAmount = amount * Math.pow(1 + monthRate, monthCount);
        return round(resultAmount, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int yearCount) {
        double resultAmount = amount * (1 + yearRate * yearCount);
        return round(resultAmount, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int yearCount = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();

        double resultAmount = 0;
        if (depositType == 1) {
            resultAmount = calculateSimplePercent(amount, 0.06, yearCount);
        } else if (depositType == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, yearCount);
        }
        System.out.println("Результат вклада: " + amount + " за " + yearCount + " лет превратятся в " + resultAmount);
    }
}
