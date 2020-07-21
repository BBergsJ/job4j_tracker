package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class DiapasnFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasnFunction test = new DiapasnFunction();
        List<Double> result = test.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        DiapasnFunction test = new DiapasnFunction();
        List<Double> result = test.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenWithFinalFunctionThenWithFinalResults() {
        DiapasnFunction test = new DiapasnFunction();
        List<Double> result = test.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32.0, 64.0, 128.0);
        assertThat(result, is(expected));
    }
}