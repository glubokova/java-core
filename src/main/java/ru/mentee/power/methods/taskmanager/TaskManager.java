package ru.mentee.power.methods.taskmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int nextId = 1;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public Task addTask(String title, String description, Date dueDate, Task.Priority priority) {
        Task task = new Task(nextId++, title, description, dueDate, priority);
        tasks.add(task);
        return task;
    }

    public Task addTask(String title) {
        return addTask(title, "", null, Task.Priority.MEDIUM);
    }

    public Task addTask(String title, String description) {
        return addTask(title, description, null, Task.Priority.MEDIUM);
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public boolean removeTask(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    public boolean markTaskAsCompleted(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            task.markAsCompleted();
            return true;
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getCompletedTasks() {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> getOverdueTasks() {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isOverdue()) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> getTasksByPriority(Task.Priority priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> searchTasks(String query) {
        if (query == null || query.isBlank()) return new ArrayList<>();
        String q = query.toLowerCase().trim();
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            boolean titleMatch = task.getTitle() != null &&
                    task.getTitle().toLowerCase().contains(q);
            boolean descMatch = task.getDescription() != null &&
                    task.getDescription().toLowerCase().contains(q);

            if (titleMatch || descMatch) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> sortTasksByDueDate() {
        List<Task> sorted = new ArrayList<>(tasks);
        int n = sorted.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Date date1 = sorted.get(j).getDueDate();
                Date date2 = sorted.get(j + 1).getDueDate();
                if (date1 == null && date2 == null) continue;
                if (date1 == null) {
                    Task temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                } else if (date2 == null) {
                } else if (date1.after(date2)) {
                    Task temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }

    public List<Task> sortTasksByPriority() {
        List<Task> sorted = new ArrayList<>(tasks);
        sorted.sort((t1, t2) -> Integer.compare
                (t2.getPriority().ordinal(),
                        t1.getPriority().ordinal()));
        return sorted;
    }

    private int comparePriority(Task.Priority p1, Task.Priority p2) {
        int weight1 = p1.ordinal();
        int weight2 = p2.ordinal();
        return Integer.compare(weight1, weight2);
    }

    public void printAllTasks() {
        printTasks(tasks, "Все задачи:");
    }

    public void printTasks(List<Task> taskList, String header) {
        System.out.println("===" + header + "===");
        if (taskList.isEmpty()) {
            System.out.println("Задачи не найдены.");
        } else {
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
        System.out.println();
    }
}