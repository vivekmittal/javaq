package com.javaq.construct;

import com.javaq.mixins.Conditionable;
import com.javaq.mixins.Joinable;
import com.javaq.mixins.Whereable;
import com.javaq.mixins.JavaQContext;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * @author Vivek Mittal
 */
public class From implements Joinable, Whereable, Conditionable {
    private final List<String> tables;
    private final JavaQContext context;

    From(JavaQContext context, String[] tables) {
        this.context = context;
        this.tables = Arrays.asList(tables);
    }

    @Override
    public String sql() {
        return context.sql() + " FROM " + tables.stream().collect(joining(", "));
    }
}
