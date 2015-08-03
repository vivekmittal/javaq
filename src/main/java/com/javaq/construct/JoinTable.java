package com.javaq.construct;

import com.javaq.mixins.Joinable;
import com.javaq.mixins.Whereable;
import com.javaq.mixins.JavaQContext;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * @author Vivek Mittal
 */
public class JoinTable implements Joinable, Whereable {
    private JavaQContext context;
    private JoinType joinType;
    private List<String> tables;

    public JoinTable(JavaQContext context, JoinType joinType, String... tables) {
        this.context = context;
        this.joinType = joinType;
        this.tables = Arrays.asList(tables);
    }

    public On on(String condition) {
        return new On(this, condition);
    }

    @Override
    public String sql() {
        return context.sql() + " " + joinType.getType() + " " + tables.stream().collect(joining(" ,"));
    }
}
