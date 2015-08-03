package com.javaq.construct;

import com.javaq.mixins.JavaQContext;

/**
 * @author Vivek Mittal
 */
public class Limit implements JavaQContext {
    private final JavaQContext context;
    private final int limit;

    public Limit(JavaQContext context, int limit) {
        this.context = context;
        this.limit = limit;
    }

    @Override
    public String sql() {
        return context.sql() + " LIMIT " + limit;
    }
}
