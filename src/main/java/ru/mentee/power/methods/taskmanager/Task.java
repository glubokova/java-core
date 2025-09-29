package ru.mentee.power.methods.taskmanager;

import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private boolean completed;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Task(int id, String title, String description, Date dueDate, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public Task(int id, String title) {
        this(id, title, "", null, Priority.MEDIUM);
    }

    public Task(int id, String title, String description) {
        this(id, title, description, null, Priority.MEDIUM);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public boolean isOverdue() {
        if (dueDate == null) return false;
        Date now = new Date();
        return dueDate.before(now) && !completed;
    }

    @Override
    public String toString() {
        String status = completed ? "yes" : "no";
        String dateStr = (dueDate == null) ? "нет даты" : dueDate.toString();
        return String.format("Задача #%d: '%s' [%s] | Приоритет: %s | Срок: %s",
                id,title, status, priority, dateStr);
    }
}