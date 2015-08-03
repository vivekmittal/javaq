package com.javaq.construct;

import com.javaq.mixins.Orderable;
import com.javaq.mixins.JavaQContext;

/**
 * @author Vivek Mittal
 */
public class GroupBy implements Orderable {
    private final JavaQContext context;
    private final String variable;

    public GroupBy(JavaQContext context, String variable) {
        this.context = context;
        this.variable = variable;
    }

    @Override
    public String sql() {
        return context.sql() + " GROUP BY " + variable;
    }
}
