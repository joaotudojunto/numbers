package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    private List<Integer> list;
    @BeforeEach
    public void helperMethod(){
        list =  Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {

        //List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {


        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        helperMethod();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        class ListDeduplicatorStub implements GenericListDeduplicator{


            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1,2,4);
            }
        }

        ListAggregator aggregator = new ListAggregator();
        ListDeduplicatorStub deduplicator = new ListDeduplicatorStub();
        int distinct = aggregator.distinct(Arrays.asList(1,2,4,2), deduplicator);

        Assertions.assertEquals(3, distinct);


    }



}