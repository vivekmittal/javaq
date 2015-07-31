package com.javaq.construct;

import com.javaq.mixins.Conditionable;
import com.javaq.mixins.JavaQContext;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
public class InValues implements Conditionable {
    private final List<String> values;
    private final JavaQContext context;

    public InValues(JavaQContext context, String... values) {
        this.context = context;
        this.values = Arrays.asList(values);
    }

    @Override
    public String sql() {
        return context.sql() + " IN (" + values.stream().map(value -> "'" + value + "'").collect(joining(", ")) + ")";
    }
}