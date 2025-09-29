package ru.mentee.power.methods.taskmanager;

import java.util.Date;

public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
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
