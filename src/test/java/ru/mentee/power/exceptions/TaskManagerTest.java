package ru.mentee.power.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;

class TaskManagerTest {
    private TaskManager account;
    private static final double INITIAL_BALANCE = 1000.0;
    private static final String AACCOUNT_ID = "ACC-123";

    @BeforeEach
    void setUp() {
        account = new TaskManager(AACCOUNT_ID, INITIAL_BALANCE);
    }

    @Test
    @DisplayName("Конструктор должен правильно устанавливать начальный баланс и ID")
    void constructorShouldSetInitialBalanceAndId() {
        assertThat(account.getId()).isEqualTo(AACCOUNT_ID);
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE);
    }

    @Test
    @DisplayName("Конструктор должен выбрасывать IllegalArgumentException при отрицательном балансе")
    void constructorShouldhrowIllegalArgumentExceptionForNegativeBalance() {
        assertThatThrownBy(() -> new TaskManager("TEST", -100.0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Начальный баланс не может быть отрицательным");
    }

    @Test
    @DisplayName("Метод deposit должен увеличивать баланс при положительной сумме")
    void depositShouldIncreaseBalanceForPositiveAmount() {
        double depositAmount = 500.0;
        account.deposit(depositAmount);
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE + depositAmount);
    }

    @Test
    @DisplayName("Метод deposit должен допускать нулевую сумму")
    void depositShouldAllowZeroAmount() {
        account.deposit(0.0);
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE);
    }

    @Test
    @DisplayName("Метод deposit должен выбрасывать IllegalArgumentException при отрицательной сумме")
    void depositShouldThrowIllegalArgumentExceptionForNegativeAmount() {
        double negativeAmount = -100.0;
        assertThatThrownBy(() -> account.deposit(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Сумма депозита не может быть отрицательной");
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE);
    }

    @Test
    @DisplayName("Метод withdraw должен уменьшать баланс при корректной сумме")
    void withdrawShouldDecreaseBalanceForValidAmount() throws TaskValidationException {
        double withdrawAmount = 300.0;
        account.withdraw(withdrawAmount);
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE - withdrawAmount);
    }

    @Test
    @DisplayName("Метод withdraw должен позволять снять полный баланс")
    void withdrawShouldAllowWithdrawingFullBalance() throws TaskValidationException {
        account.withdraw(INITIAL_BALANCE);
        assertThat(account.getBalance()).isEqualTo(0.0);
    }

    @Test
    @DisplayName("Метод withdraw должен допускать нулевую сумму")
    void withdrawShouldAllowZeroAmount() throws TaskValidationException {
        account.withdraw(0.0);
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE);
    }

    @Test
    @DisplayName("Метод withdraw должен выбрасывать IllegalArgumentException при отрицательной сумме")
    void withdrawShouldThrowIllegalArgumentExceptionForNegativeAmount() {
        double negativeAmount = -100.0;
        assertThatThrownBy(() -> account.withdraw(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Сумма снятия не может быть отрицательной");
        assertThat(account.getBalance()).isEqualTo(INITIAL_BALANCE);
    }

    @Test
    @DisplayName("Метод withdraw должен выбрасывать TaskValidationException при превышении баланса")
    void withdrawShouldThrowTaskValidationExceptionWhenAmountExceedsBalance() {
        double excessiveAmount = INITIAL_BALANCE + 100.0;
        assertThatThrownBy(() -> account.withdraw(excessiveAmount))
                .isInstanceOf(TaskValidationException.class)
                .hasMessageContaining("Недостаточно средств");

        TaskValidationException exception = catchThrowableOfType(
                () -> account.withdraw(excessiveAmount),
                TaskValidationException.class
        );

        assertThat(exception.getBalance()).isEqualTo(INITIAL_BALANCE);
        assertThat(exception.getWithdrawAmount()).isEqualTo(excessiveAmount);
        assertThat(exception.getDeficit()).isEqualTo(100.0);
        assertThat(exception.getBalance()).isEqualTo(INITIAL_BALANCE);
    }
}