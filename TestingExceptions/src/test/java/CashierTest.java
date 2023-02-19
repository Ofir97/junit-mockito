import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {

    @Test(expected = IllegalArgumentException.class)
    public void validateTransactionUnacceptedCurrency() {
        Cashier.validateTransaction("USD", 100);
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void validateTransactionInvalidAmount() {
        Cashier.validateTransaction("EUR", -20);
    }

    @Test
    public void validateTransactionValidInput() {
        double amount = Cashier.validateTransaction("EUR", 200);
        assertEquals(200, amount);
    }

}