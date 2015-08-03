package com.javaq.construct;

import com.javaq.mixins.Conditionable;
import com.javaq.mixins.JavaQContext;

/**
 * @author Vivek Mittal
 */
public class Like implements Conditionable {
    private final JavaQContext context;
    private final String condition;

    public Like(JavaQContext context, String condition) {
        this.context = context;
        this.condition = condition;
    }

    @Override
    public String sql() {
        return context.sql() + " LIKE '" + condition + "'";
    }
}
