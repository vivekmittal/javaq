package com.javaq.construct;

import com.javaq.mixins.Conditionable;
import com.javaq.mixins.JavaQContext;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
public class InSelect implements Conditionable {
    private final JavaQContext condition;
    private final JavaQContext context;

    public InSelect(JavaQContext context, JavaQContext condition) {
        this.context = context;
        this.condition = condition;
    }

    @Override
    public String sql() {
        return context.sql() + " IN (" + condition.sql() + ")";
    }
}
