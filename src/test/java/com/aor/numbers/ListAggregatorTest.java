package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    public List<Integer> helperMethod(){
        return Arrays.asList(-1,-4, -5);
        //return Arrays.asList(1,2,4,2,5);
    }
    @Test
    public void max_bug_7263() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        if(max != -1){
            System.out.println("Bug Report #7263\nLists created with values -1, -4, -5, and result should be -1, got " + max + " " + "instead");
        }
    }

    @Test
    public void sum() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(-10, sum);

    }

    @Test
    public void max() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(-5, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3, distinct);
    }
}
