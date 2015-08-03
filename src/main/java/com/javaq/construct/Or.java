package com.javaq.construct;

import com.javaq.mixins.Conditionable;
import com.javaq.mixins.JavaQContext;
import com.javaq.mixins.InClauseable;

/**
 * @author Vivek Mittal
 */
public class Or implements InClauseable {
    private final String condition;
    private final JavaQContext context;

    public Or(JavaQContext context, String condition) {
        this.context = context;
        this.condition = condition;
    }

    @Override
    public String sql() {
        return context.sql() + " OR " + condition;
    }
}
