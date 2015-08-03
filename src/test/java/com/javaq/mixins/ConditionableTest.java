package com.javaq.mixins;

import org.testng.annotations.Test;

import static com.javaq.util.JavaQMatchers.implementing;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Vivek Mittal
 */
@Test
public class ConditionableTest {
    public void groupable() {
        assertThat(Conditionable.class, is(implementing(Groupable.class)));
    }

    public void limitable() {
        assertThat(Conditionable.class, is(implementing(Limitable.class)));
    }

    public void orderable() {
        assertThat(Conditionable.class, is(implementing(Orderable.class)));
    }
}