package ru.mentee.power.loop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayStatistics {

    private final int[] data;

    public ArrayStatistics(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public int findMin() {
        if (data.length == 0) {
            return Integer.MAX_VALUE;
        }
        int min = data[0];
        for (int value : data) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public int findMax() {
        if (data.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public int calculateSum() {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public double calculateAverage() {
        if (data.length == 0) return 0;
        return (double) calculateSum() / data.length;
    }

    public double calculateMedian() {
        if (data.length == 0) return 0;
        int[] sorted = Arrays.copyOf(data, data.length);
        Arrays.sort(sorted);
        int middle = sorted.length / 2;
        if (sorted.length % 2 == 1) {
            return sorted[middle];
        } else {
            return (sorted[middle - 1] + sorted[middle]) / 2.0;
        }
    }

    public int findMode() {
        if (data.length == 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : data) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int mode = data[0];
        int maxCount = 0;
        for (var entry : freq.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            if (cnt > maxCount || (cnt == maxCount && num < mode)) {
                mode = num;
                maxCount = cnt;
            }
        }
        return mode;
    }

    public double calculateStandardDeviation() {
        if (data.length < 2) return 0.0;
        double avg = calculateAverage();
        double sumSquares = 0.0;
        for (int n : data) {
            sumSquares += (n - avg) * (n - avg);
        }
        return Math.sqrt(sumSquares / data.length);
    }

    public int countGreaterThan(int value) {
        int count = 0;
        for (int n : data) {
            if (n > value) count++;
        }
        return count;
    }

    public int countLessThan(int value) {
        int count = 0;
        for (int n : data) {
            if (n < value) count++;
        }
        return count;
    }

    public boolean contains(int value) {
        for (int n : data) {
            if (n == value) return true;
        }
        return false;
    }

    public void printStatisticsReport() {
        System.out.println("====Статистический отчет====");
        System.out.println("Размер массива: " + data.length);
        System.out.println("Минимальное значение: " + findMin());
        System.out.println("Максимальное значение: " + findMax());
        System.out.println("Сумма элементов: " + calculateSum());
        System.out.println("Среднее арифметическое:" + calculateAverage());
        System.out.println("Медиана: " + calculateMedian());
        System.out.println("Мода: " + findMode());
        System.out.println("Стандартное отклонение: " + calculateStandardDeviation());
        System.out.println("================================");
    }

    public static void main(String[] args) {
        int[] testData = {5, 7, 2, 9, 3, 5, 1, 8, 5, 6};
        ArrayStatistics stats = new ArrayStatistics(testData);
        System.out.println("Исходный массив: " + Arrays.toString(testData));
        stats.printStatisticsReport();
        System.out.println("Элементов больше 5: " + stats.countGreaterThan(5));
        System.out.println("Элементов меньше 5: " + stats.countLessThan(5));
        System.out.println("Массив содержит 7: " + stats.contains(7));
        System.out.println("Массив содержит 10: " + stats.contains(10));
    }
}
