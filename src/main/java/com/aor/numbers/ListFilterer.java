package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer{
    private GenericListFilter filter;

public ListFilterer(GenericListFilter filter) {  // construtor
    this.filter = filter;
}

    public List<Integer> filter(List<Integer> list) {
        List<Integer> ret = new ArrayList<>();

        for (Integer number : list){
            if (filter.accept(number)) ret.add(number);
        }

        return ret;
    }

}

