import java.util.HashMap;

public class StepTracker {
    int stepsTarget;
    String[] months; //объявили массив, который будет содержать наименования месяцев
    HashMap<String, int[]> yearOfSteps; //объявили хэш-таблицу, которая будет хранить наименования месяцев и данные по пройденным шагам
    Converter converter = new Converter();

    StepTracker() {
        stepsTarget = 10_000;
        yearOfSteps = new HashMap<>();
        months = new String[] {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                               "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        for (int i = 0; i < 12; i++) {
            yearOfSteps.put(months[i], new int[30]);
        }
    }

    void saveSteps(String month, int day, int steps) { //метод по сохранению шагов
        if (yearOfSteps.containsKey(month)) {
            int[] stepsInDay = yearOfSteps.get(month);
            if (day >= 1 && day <=30) {
                if (steps >= 0) {
                    stepsInDay[day - 1] = steps;
                    yearOfSteps.put(month, stepsInDay);
                    System.out.println("Количество шагов сохранено.");
                } else {
                    System.out.println("Значение количества шагов не может быть отрицательным!");
                }
            } else {
                System.out.println("Номер дня введён некорректно - значение должно быть в диапазоне от 1 до 30!");
            }
        } else {
            System.out.println("Название месяца введено некорректно!");
        }
    }

    void getStepsStatistics(String month) { //метод по выводу статистики за указанный месяц
        if (yearOfSteps.containsKey(month)) {
            int[] stepsInDay = yearOfSteps.get(month);
            String daysStatistics = "";
            for (int i = 0; i < stepsInDay.length; i++) {
                daysStatistics += (i + 1) + " день: " + stepsInDay[i] + ", ";
            }
            int stepsSum = 0;
            for (int i = 0; i < stepsInDay.length; i++) {
                stepsSum += stepsInDay[i];
            }
            int stepsMax = 0;
            for (int i = 0; i < stepsInDay.length; i++) {
                if (stepsInDay[i] > stepsMax) {
                    stepsMax = stepsInDay[i];
                }
            }
            System.out.println(daysStatistics);
            System.out.println("Общее количество шагов за " + month + ": " + stepsSum);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + stepsMax);
            System.out.println("Среднее количество шагов за " + month + ": " + (stepsSum / stepsInDay.length));
            int targetRow = 0;
            int targetRowBest = 0;
            for (int i = 0; i < stepsInDay.length; i++) {
                if (stepsInDay[i] >= stepsTarget) {
                    targetRow += 1;
                    if (targetRow > targetRowBest) {
                        targetRowBest = targetRow;
                    }
                } else {
                    targetRow = 0;
                }
            }
            if (targetRowBest <= 1) {
                System.out.println("Нет подряд идущих дней, в течение которых количество " +
                                   "шагов за день было равно или выше целевого.");
            } else {
                System.out.println("Mаксимальное количество подряд идущих дней, в течение которых " +
                                   "количество шагов за день было равно или выше целевого: " + targetRowBest);
            }
            System.out.println("Пройденная дистанция в километрах: " + converter.stepsToKm(stepsSum));
            System.out.println("Количество сожжённых килокалорий: " + converter.stepsToKcal(stepsSum));
        } else {
            System.out.println("Название месяца введено некорректно!");
        }
    }

    void editStepsTarget(int stepsTarget) { //метод по изменению целевого количества шагов
        if (stepsTarget >= 0) {
            this.stepsTarget = stepsTarget;
            System.out.println("Цель изменена.");
        } else {
            System.out.println("Отрицательное число не может быть целью!");
        }
    }
}