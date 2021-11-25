package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    public List<Integer> helperMethod(){
        return Arrays.asList(1,2,4,2);
        //return Arrays.asList(1,2,4,2,5);
    }

    public void max_bug_7263() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        if(max != -1){
            System.out.println("Bug Report #7263\nLists created with values -1, -4, -5, and result should be -1, got " + max + " " + "instead");
        }
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = helperMethod();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list);
        if(distinct != 3){
            System.out.println("Bug Report #8726\nLists created with values 1, 2, 4, 2 and result should be 3, got " + distinct + " " + "instead");
        }

    }

    @Test
    public void sum() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(9, sum);

    }

    @Test
    public void max() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(4, max);
    }

    @Test
    public void min() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3, distinct);
    }
}
