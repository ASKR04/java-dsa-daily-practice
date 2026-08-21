package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateReversePolishNotationTest {
    @Test
    void evaluatesSimpleAdditionAndMultiplication() {
        String[] tokens = {"2", "1", "+", "3", "*"};

        assertEquals(9, EvaluateReversePolishNotation.evaluate(tokens));
    }

    @Test
    void respectsOperandOrderForDivision() {
        String[] tokens = {"4", "13", "5", "/", "+"};

        assertEquals(6, EvaluateReversePolishNotation.evaluate(tokens));
    }

    @Test
    void evaluatesLongerExpression() {
        String[] tokens = {
                "10", "6", "9", "3", "+", "-11", "*", "/", "*",
                "17", "+", "5", "+"
        };

        assertEquals(22, EvaluateReversePolishNotation.evaluate(tokens));
    }

    @Test
    void truncatesDivisionTowardZero() {
        String[] tokens = {"7", "-3", "/"};

        assertEquals(-2, EvaluateReversePolishNotation.evaluate(tokens));
    }
}
