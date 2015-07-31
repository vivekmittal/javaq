package com.javaq.mixins;

import com.javaq.util.JavaQMatchers;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
@Test
public class ConditionableTest {
    public void groupable() {
        assertThat(Conditionable.class, Matchers.is(JavaQMatchers.implementing(Groupable.class)));
    }

    public void limitable() {
        assertThat(Conditionable.class, Matchers.is(JavaQMatchers.implementing(Limitable.class)));
    }

    public void orderable() {
        assertThat(Conditionable.class, Matchers.is(JavaQMatchers.implementing(Orderable.class)));
    }
}