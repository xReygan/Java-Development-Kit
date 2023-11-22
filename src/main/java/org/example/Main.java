// Создать свой Java Maven/Gradle проект;
// Реализовать прикладную задачу - приложение для демонстрации парадокса Монти Холла; Можно добавить любые библиотеки
// которые считают необходимыми. Результаты должны быть сохранены в HashMap (шаг цикла -> результат)
// Необходимо вывести статистику по результату - количество позитивных и негативных результатов,
// процент от общего количества шагов цикла.
package org.example;

import java.util.HashMap;
import java.util.Random;

// По условию игры Монти Холла есть 3 двери, где за одной из них выигрыш, а в двух других проигрыш.
// Если игрок выбрал выигрышную дверь и при этом он поменяет выбор, то игрок проиграл. Если игрок выбрал проигрышную
// дверь и поменяет выбор, то игрок выиграл.
// Соответственно, еси игрок не меняет выбор, то он выигрывает, если угадал выигрышную дверь и проигрывает если выбрал
// проигрышную дверь.

public class Main {
    static int numberOfDoor = 3;
    static int totalCycleSteps = 1000;
    public static void main(String[] args) {
        int numberOfVictories = 0;
        int numberOfLoses = 0;
        for (int i = 0; i < game_1().size(); i++) {
            if (game_1().get(i + 1)) {
                numberOfVictories ++;
            } else {
                numberOfLoses ++;
            }
        }
        System.out.println("Стратегия игры, когда игрок меняет свой выбор (из " + totalCycleSteps + " вариантов):");
        System.out.println("Выигрышных вариантов: " + numberOfVictories +
                           " раз;   Проигрышных вариантов: " + numberOfLoses + " раз");
        double percentWinner = (double) (numberOfVictories * 100) / totalCycleSteps;
        double percentLoser = (double) (numberOfLoses * 100) / totalCycleSteps;
        System.out.println("Процент выигрышных вариантов: " + percentWinner + "%;   " +
                           "Процент проигрышных вариантов: " + percentLoser + "%");
        System.out.println();

        numberOfVictories = 0;
        numberOfLoses = 0;
        for (int i = 0; i < game_2().size(); i++) {
            if (game_2().get(i + 1)) {
                numberOfVictories ++;
            } else {
                numberOfLoses ++;
            }
        }
        System.out.println("Стратегия игры, когда игрок оставляет свой выбор (из " + totalCycleSteps + " вариантов):");
        System.out.println("Выигрышных вариантов: " + numberOfVictories +
                " раз;   Проигрышных вариантов: " + numberOfLoses + " раз");
        percentWinner = (double) (numberOfVictories * 100) / totalCycleSteps;
        percentLoser = (double) (numberOfLoses * 100) / totalCycleSteps;
        System.out.println("Процент выигрышных вариантов: " + percentWinner + "%;   " +
                "Процент проигрышных вариантов: " + percentLoser + "%");
    }

    //Стратегия игры game_1() заключается в замене первоначально выбранной двери
    public static HashMap<Integer, Boolean> game_1() {
        HashMap<Integer, Boolean> result = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < totalCycleSteps; i ++) {
            int winningDoor = random.nextInt(numberOfDoor) + 1;
            int selectedDoor = random.nextInt(numberOfDoor) + 1;
            if (winningDoor == selectedDoor) {
                //если Игрок изначально выбрал выигрышную дверь, то меняя свой выбор Он проигрывает
                result.put(i + 1, false);
            } else {
                //если Игрок изначально выбрал проигрышную дверь, то меняя свой выбор Он выигрывает
                result.put(i + 1, true);
            }
        }
        return result;
    }

    //Стратегия игры game_2() заключается в подтверждении выбора первоначально выбранной двери
    public static HashMap<Integer, Boolean> game_2() {
        HashMap<Integer, Boolean> result = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < totalCycleSteps; i ++) {
            int winningDoor = random.nextInt(numberOfDoor) + 1;
            int selectedDoor = random.nextInt(numberOfDoor) + 1;
            if (winningDoor == selectedDoor) {
                //если Игрок изначально выбрал выигрышную дверь, то Он выигрывает
                result.put(i + 1, true);
            } else {
                //если Игрок изначально выбрал проигрышную дверь, то Он проигрывает
                result.put(i + 1, false);
            }
        }
        return result;
    }
}