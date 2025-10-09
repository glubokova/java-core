package ru.mentee.power.exceptions;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TaskManagerDemo {
    public static void main(String[] args) throws TaskValidationException {
        try (Scanner scanner = new Scanner(System.in)) {
            TaskManager account = null;
            while (account == null) {
                try {
                    System.out.print("Введите ID счета: ");
                    String accountId = scanner.nextLine();
                    System.out.println("Введите начальный баланс: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    account = new TaskManager(accountId, initialBalance);
                    System.out.printf("Счет %s успешно создан с начальным балансом: %.2f%n",
                            accountId, initialBalance);
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введено некорректное число. Попробуйте снова.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибки создания счета: " + e.getMessage());
                }
            }

            boolean running = true;
            while (running) {
                printMenu();

                try {
                    System.out.print("Выберите операцию: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            try {
                                System.out.print("Введите сумму для внесения: ");
                                double depositAmount = scanner.nextDouble();
                                scanner.nextLine();
                                account.deposit(depositAmount);
                            } catch (InputMismatchException e) {
                                System.out.println("Ошибка: Введена некорректная сумма.");
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println("Ошибка внесения: " + e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                System.out.println("Введите сумму для снятия: ");
                                double withdrawAmount = scanner.nextDouble();
                                scanner.nextLine();
                                account.withdraw(withdrawAmount);
                            } catch (InputMismatchException e) {
                                System.out.println("Ошибка: Введена некорректная сумма.");
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println("Ошибка снятия: " + e.getMessage());
                            } catch (TaskValidationException e) {
                                System.out.println("Ошибка снятия: " + e.getMessage());
                                System.out.printf("Текущий баланс: %.2f, Запрошенная сумма: %.2f, Недостающая сумма: %.2f%n",
                                        e.getBalance(), e.getWithdrawAmount(), e.getDeficit());
                            }
                            break;

                        case 3:
                            System.out.printf("Текущий баланс счета %s: %.2f%n", account.getId(), account.getBalance());
                            break;

                        case 4:
                            running = false;
                            System.out.println("Выход из программы...");
                            break;

                        default:
                            System.out.println("Неверный выбор. Попробуйте снова.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка:Введен некорректный выбор меню.");
                    scanner.nextLine();
                }
                System.out.println();
            }
        }
        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        System.out.println("=== МЕНЮ УПРАВЛЕНИЯ СЧЕТОМ ===");
        System.out.println("1. Внести деньги");
        System.out.println("2. Снять деньги");
        System.out.println("3. Проверить баланс");
        System.out.println("4. Выход");
        System.out.println("==============================");
    }
}