import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MyFirstTest {
    private int globalVar = 10;
    Integer age = 18;

    //  BigDecimal price = new BigDecimal("10.01");
/*
Many
Row
Comment
 */
    // One Row comment
    @Test
    public void firstTest() {
        System.out.println("Hello, corona!");
        int sum = (sumTwoDigits(15, 20));
        System.out.println("Sum is: " + sum);
        System.out.println(sumTwoDigits(20, 25)); // CTRL = / (comment row or many rows)
        age = 19;
    }

    private int sumTwoDigits(int a, int b) {
        int c = a + b;
        return c;
    }

}
