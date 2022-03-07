public class Converter {
    double stepsToKm(int stepsSum) {
        double stepsInKm = (stepsSum * 0.75) / 1000; //преобразуем метровый эквивалент шагов в километровый
        return stepsInKm;
    }

    int stepsToKcal(int stepsSum) {
        int stepsInKcal = (stepsSum * 50) / 1000; //преобразуем калорийный эквивалент шагов в килокалорийный
        return stepsInKcal;
    }
}