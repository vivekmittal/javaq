package com.javaq.construct;

import com.javaq.mixins.Joinable;
import com.javaq.mixins.Whereable;
import com.javaq.mixins.JavaQContext;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
public class On implements Joinable, Whereable {
    private final JavaQContext context;
    private final String condition;

    On(JavaQContext context, String condition) {
        this.context = context;
        this.condition = condition;
    }

    @Override
    public String sql() {
        return context.sql() + " ON " + condition;
    }
}
