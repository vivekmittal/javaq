package com.javaq.mixins;

import com.javaq.construct.Where;

/**
 * @author Vivek Mittal
 */
public interface Whereable extends JavaQContext {
    public default Where where(String condition) {
        return new Where(this, condition);
    }
}
