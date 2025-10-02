package ru.mentee.power.methods.taskmanager;

import java.util.Date;

import ru.mentee.power.methods.taskmanager.Task;
import ru.mentee.power.methods.taskmanager.TaskManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManagerDemo {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        initializeTasks();
        boolean running = true;
        System.out.println("Добро пожаловать  Менеджер Задач(с базовой обработкй ошибок)!");

        while (running) {
            printMenu();
            int choice = -1;
            try {
                System.out.println("Выберите действие (1-5): ");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода: Пожалуйста, введите номер действия (число).");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addTaskUI();
                    break;
                case 2:
                    markTaskAsCompletedUI();
                    break;
                case 3:
                    removeTaskUI();
                    break;
                case 4:
                    taskManager.printAllTasks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите от 1 до 5.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void addTaskUI() {
        try {
            System.out.println("Введите название задачи: ");
            String title = scanner.nextLine();
            Task newTask = taskManager.addTask(title);
            if (newTask != null) {
                System.out.println("Задача '" + newTask.getTitle() + "' (ID: " + newTask.getId() + ") успешно добавлена.");
            } else {
                System.out.println("Не удалось добавить задачу.");
            }
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка при добавлении задачи: " + e.getMessage());
        }
    }

    private static void markTaskAsCompletedUI() {
        try {
            System.out.println("Введите ID задачи для отметки как выполненной: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id <= 0) {
                throw new IllegalArgumentException("ID задачи не может быть отрицательным или нулем. ");
            }

            boolean success = taskManager.markTaskAsCompleted(id);
            if (success) {
                System.out.println("Задача с ID " + id + " не найдена.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: Пожалуйста, введите ID задачи(целое число).");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка при отметке задачи: " + e.getMessage());
        }
    }

    private static void removeTaskUI() {
        try {
            System.out.println("Введите ID задачи для удаления: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id <= 0) {
                throw new IllegalArgumentException("ID задачи не может быть отрицательным или нулем");
            }

            boolean success = taskManager.removeTask(id);
            if (success) {
                System.out.println("Задача с ID " + id + " удалена.");
            } else {
                System.out.println("Задача с ID " + id + " не найдена");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: Пожалуйста, введите ID задачи(целое число).");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка при удалении задачи: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("===== МЕНЮ =====");
        System.out.println("1. Добавить задачу(только название)");
        System.out.println("2. Отметить задачу как выполненную");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Показать все задачи");
        System.out.println("5. Выход");
        System.out.println("================");
    }

    private static void initializeTasks() {
        taskManager.addTask("Купить молоко", "2 литра", new Date(), Task.Priority.HIGH);
        taskManager.addTask("Прочитать книгу");
        taskManager.addTask("Сделать упражнение", "30 минут в день");

        System.out.println("Поиск 'молоко':");
        taskManager.printTasks(taskManager.searchTasks("молоко"), "Результаты поиска");
        System.out.println("Задачи с высоким приоритетом:");
        taskManager.printTasks(taskManager.getTasksByPriority(Task.Priority.HIGH), "Высокий приоритет");
        System.out.println("Сортировка по приоритету:");
        taskManager.printTasks(taskManager.sortTasksByPriority(), "По приоритету");

        taskManager.markTaskAsCompleted(1);
        System.out.println("После выполнения задачи 1:");
        taskManager.printAllTasks();
    }
}
