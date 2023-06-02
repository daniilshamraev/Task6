import java.util.Scanner;

public class GymSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод списка весов
        System.out.print("Введите список весов: ");
        String weightsString = scanner.nextLine();

        // Разбиение строки на массив чисел
        String[] weightsArray = weightsString.split(" ");
        int[] weights = new int[weightsArray.length];
        for (int i = 0; i < weightsArray.length; i++) {
            weights[i] = Integer.parseInt(weightsArray[i]);
        }

        // Сортировка по сумме цифр
        for (int i = weights.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (sumOfDigits(weights[j]) > sumOfDigits(weights[maxIndex])) {
                    maxIndex = j;
                }
            }
            int temp = weights[i];
            weights[i] = weights[maxIndex];
            weights[maxIndex] = temp;
        }

        // Вывод отсортированного списка
        System.out.print("Отсортированный список: ");
        for (int i = 0; i < weights.length; i++) {
            System.out.print(weights[i] + " ");
        }
    }

    // Функция для вычисления суммы цифр числа
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
