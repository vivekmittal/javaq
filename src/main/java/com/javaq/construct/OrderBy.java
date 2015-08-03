package com.javaq.construct;

import com.javaq.mixins.JavaQContext;
import com.javaq.mixins.Limitable;
import com.javaq.mixins.Orderable;

/**
 * @author Vivek Mittal
 */
public class OrderBy implements Limitable {
    private final JavaQContext context;
    private final String variable;
    private final Orderable.Order order;

    public OrderBy(JavaQContext context, String variable, Orderable.Order order) {
        this.context = context;
        this.variable = variable;
        this.order = order;
    }

    @Override
    public String sql() {
        return context.sql() + " ORDER BY " + variable + " " + order;
    }
}
