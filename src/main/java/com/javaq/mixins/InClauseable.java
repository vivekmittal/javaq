package com.javaq.mixins;

import com.javaq.construct.InSelect;
import com.javaq.construct.InValues;
import com.javaq.construct.Like;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
public interface InClauseable extends Conditionable {
    public default Conditionable in(JavaQContext select) {
        return new InSelect(this, select);
    }

    public default Conditionable in(String... clauses) {
        return new InValues(this, clauses);
    }

    public default Conditionable like(String condition) {
        return new Like(this, condition);
    }
}
