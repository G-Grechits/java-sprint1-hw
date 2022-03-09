import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Привет! Это твой счётчик шагов."); //приветствие

        while (true) {
            printMenu();
            String command = scanner.next(); //считываем команду (выбрал next(), а не nextLine(), чтобы не выводил
            // "Неправильный ввод команды!" после того, как уже принял и выполнил какую-либо команду из доступных)
            if (command.equals("1")) { // прошу прощения, но switch-case я задействовать не буду, т.к. мы его пока не изучали)
                System.out.println("Введи название месяца с прописной буквы");
                String month = scanner.next();
                System.out.println("Введи номер дня от 1 до 30");
                int day = scanner.nextInt();
                System.out.println("Введи количество пройденных шагов");
                int steps = scanner.nextInt();
                stepTracker.stepsKeeper(month, day, steps); //вызываем метод по сохранению шагов
            } else if (command.equals("2")) {
                System.out.println("Введи название месяца, статистика за который тебя интересует, с прописной буквы");
                String month = scanner.next();
                stepTracker.stepsStatistics(month); //вызываем метод по выводу статистики за указанный месяц
            } else if (command.equals("3")) {
                System.out.println("Введи новую цель по количеству шагов за день");
                int stepsTarget = scanner.nextInt();
                stepTracker.editStepsTarget(stepsTarget); //вызываем метод по изменению целевого количества шагов
            } else if (command.equals("0")) {
                System.out.println("Программа завершена. Всего доброго!");
                return; //останавливаем цикл и программу
            } else {
                System.out.println("Неправильный ввод команды! Введи цифру от 0 до 3.");
            }
        }
    }

    static void printMenu() {
        System.out.println("Введи цифру соответсвенно тому, что хочешь сделать:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Получить статистику по шагам за определённый месяц");
        System.out.println("3 - Изменить свою цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}