package com.javaq;

import com.javaq.construct.Select;

/**
 * @author Vivek Mittal
 */
public class JavaQ {
    public static Select select(String... columns) {
        if (columns == null || columns.length == 0)
            columns = new String[]{"*"};

        return new Select(columns);
    }
}
