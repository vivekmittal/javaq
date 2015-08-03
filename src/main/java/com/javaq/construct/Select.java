package com.javaq.construct;

import com.javaq.mixins.JavaQContext;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * @author Vivek Mittal
 */
public class Select implements JavaQContext {
    private final List<String> columns;

    public Select(String ... columns) {
        this.columns = Arrays.asList(columns);
    }

    public From from(String...tables) {
        return new From(this, tables);
    }

    @Override
    public String sql() {
        return "SELECT " + columns.stream().collect(joining(", "));
    }
}
