package ru.mentee.power.methods.taskmanager;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        taskManager.addTask("Важная задача", "Выполнить скорее", createDate(2023, 5, 15), Task.Priority.HIGH);
        taskManager.addTask("Обычная задача", "В течении недели", createDate(2023, 6, 1), Task.Priority.MEDIUM);
        taskManager.addTask("Несрочная задача", "Когда будет время", createDate(2023, 7, 1), Task.Priority.LOW);
    }

    @Test
    void testAddTask() {
        Task task = taskManager.addTask("Новая задача", "Описание", createDate(2023, 8, 1), Task.Priority.HIGH);
        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo("Новая задача");
        assertThat(task.getDescription()).isEqualTo("Описание");
        assertThat(task.getPriority()).isEqualTo(Task.Priority.HIGH);
        assertThat(task.isCompleted()).isFalse();
    }

    @Test
    void testGetTaskById() {
        Task task = taskManager.getTaskById(1);
        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo("Важная задача");
        Task notFound = taskManager.getTaskById(999);
        assertThat(notFound).isNull();
    }

    @Test
    void testGetTasksByPriority() {
        List<Task> highPriorityTasks = taskManager.getTasksByPriority(Task.Priority.HIGH);
        assertThat(highPriorityTasks).hasSize(1);
        assertThat(highPriorityTasks.get(0).getTitle()).isEqualTo("Важная задача");
        List<Task> emptyList = taskManager.getTasksByPriority(Task.Priority.LOW);
        assertThat(emptyList).isNotEmpty();
    }

    @Test
    void testSearchTasks() {
        List<Task> foundByTitle = taskManager.searchTasks("Важная");
        assertThat(foundByTitle).hasSize(1);

        List<Task> foundByDesc = taskManager.searchTasks("недели");
        assertThat(foundByDesc).hasSize(1);
        if (!foundByTitle.isEmpty() && !foundByDesc.isEmpty()) {
            assertThat(foundByTitle.get(0).getId()).isNotEqualTo(foundByDesc.get(0).getId());
        }
        List<Task> emptySearch = taskManager.searchTasks("");
        assertThat(emptySearch).isEmpty();

        List<Task> notFound = taskManager.searchTasks("несуществующий");
        assertThat(notFound).isEmpty();
    }

    @Test
    void testSortTasksByPriority() {
        List<Task> sorted = taskManager.sortTasksByPriority();
        assertThat(sorted.get(0).getPriority()).isEqualTo(Task.Priority.HIGH);
        assertThat(sorted.get(1).getPriority()).isEqualTo(Task.Priority.MEDIUM);
        assertThat(sorted.get(2).getPriority()).isEqualTo(Task.Priority.LOW);
    }

    private static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}