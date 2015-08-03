package com.javaq.mixins;

import java.util.Set;
import org.reflections.Reflections;
import org.testng.annotations.Test;

import static com.javaq.util.JavaQMatchers.implementing;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Vivek Mittal
 */
@Test
public class JavaQContextTest {
    public void constructsMustImplementContext() {
        final Reflections reflections = new Reflections("com.javaq.construct");
        final Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);

        for (Class<?> aClass : classes) {
            assertThat(aClass, is(implementing(JavaQContext.class)));
        }
    }

    public void mixinsMustImplementContext() {
        final Reflections reflections = new Reflections("com.javaq.mixins");
        final Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);

        for (Class<?> aClass : classes) {
            assertThat(aClass, is(implementing(JavaQContext.class)));
        }
    }
}