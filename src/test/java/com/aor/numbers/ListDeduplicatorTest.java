package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest  {


    @Test
    public void deduplicate() {


        class ListSorterStub implements GenericListSorter{

            @Override
            public List<Integer> sort(List<Integer> l) {
                return Arrays.asList(1, 2, 4, 2);
            }
        };

        ListSorterStub sorterStub = new ListSorterStub();


        List<Integer> list = Arrays.asList(1,2,4,2,5);
        List<Integer> expected = Arrays.asList(1,2,4,5);
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, distinct);


    }


}

