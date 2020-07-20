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
        List<Double> result = test.diapason(5, 8, x -> Math.log(x) + 1);
        List<Double> expected = Arrays.asList(2.6094379124341005, 2.791759469228055, 2.9459101490553135);
        assertThat(result, is(expected));
    }
}