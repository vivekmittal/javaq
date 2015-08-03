package com.javaq.mixins;

import com.javaq.construct.JoinTable;

import static com.javaq.construct.JoinType.INNER_JOIN;
import static com.javaq.construct.JoinType.LEFT_JOIN;

/**
 * @author Vivek Mittal
 */
public interface Joinable extends JavaQContext {
    public default JoinTable join(String... tables) {
        return new JoinTable(this, INNER_JOIN, tables);
    }

    public default JoinTable leftJoin(String... tables) {
        return new JoinTable(this, LEFT_JOIN, tables);
    }
}
