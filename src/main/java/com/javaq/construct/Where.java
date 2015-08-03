package com.javaq.construct;


import com.javaq.mixins.InClauseable;
import com.javaq.mixins.JavaQContext;

/**
 * @author Vivek Mittal
 */
public class Where implements InClauseable {
    private final JavaQContext context;
    private final String condition;

    public Where(JavaQContext context, String condition) {
        this.context = context;
        this.condition = condition;
    }

    @Override
    public String sql() {
        return context.sql() + " WHERE " + condition;
    }
}
