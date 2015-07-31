package com.javaq.mixins;

import com.javaq.construct.Limit;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
public interface Limitable extends JavaQContext{
    public default Limit limit(int limit) {
        return new Limit(this, limit);
    }
}
