package com.javaq.mixins;

import com.javaq.construct.Or;
import com.javaq.construct.And;

/**
 * @author Vivek Mittal
 */
public interface Conditionable extends JavaQContext, Orderable, Groupable, Limitable {
    public default And and(String condition) {
        return new And(this, condition);
    }

    public default Or or(String condition) {
        return new Or(this, condition);
    }
}
