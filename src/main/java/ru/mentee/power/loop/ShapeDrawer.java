package ru.mentee.power.loop;

public class ShapeDrawer {
    public String drawSquare(int size) {
        if (size <= 0) return "";
        StringBuilder square = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square.append("*");
            }
            if (i < size - 1) {
                square.append("\n");
            }
        }
        return square.toString();
    }

    public String drawEmptySquare(int size) {
        if (size <= 0) return "";
        StringBuilder emptySquare = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    emptySquare.append("*");
                } else {
                    emptySquare.append(" ");
                }
            }
            if (i < size - 1) {
                emptySquare.append("\n");
            }
        }
        return emptySquare.toString();
    }

    public String drawTriangle(int height) {
        if (height <= 0) return "";
        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                triangle.append("*");
            }
            if (i < height - 1) {
                triangle.append("\n");
            }
        }
        return triangle.toString();
    }

    public String drawRhombus(int size) {
        if (size <= 0) {
            return "";
        }
        if (size % 2 == 0) {
            size++;
        }

        StringBuilder rhombus = new StringBuilder();
        int middle = size / 2;

        for (int i = -middle; i <= middle; i++) {
            int row = Math.abs(i);
            int stars = 2 * (middle - row) + 1;
            int spaces = row;

            for (int j = 0; j < spaces; j++) {
                rhombus.append(" ");
            }
            for (int j = 0; j < stars; j++) {
                rhombus.append("*");
            }
            if (i < middle) { // Не добавляем \n после последней строки
                rhombus.append("\n");
            }
        }

        return rhombus.toString();
    }


    public static void main(String[] args) {
        ShapeDrawer drawer = new ShapeDrawer();
        System.out.println("Квадрат 5*5:");
        System.out.println(drawer.drawSquare(5));
        System.out.println("\nПустой квадрат 5*5:");
        System.out.println(drawer.drawEmptySquare(5));
        System.out.println("\nТреугольник высотой 5:");
        System.out.println(drawer.drawTriangle(5));
        System.out.println("Ромб размером 5:");
        System.out.println(drawer.drawRhombus(5));
    }
}