package com.javaq.util;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author Vivek Mittal <vivek.mittal@flipkart.com>
 */
public class JavaQMatchers {
    public static Matcher<? super Class> implementing(Class expected) {
        return new TypeSafeMatcher<Class>() {
            private Class actual;

            @Override
            protected boolean matchesSafely(Class actual) {
                this.actual = actual;
                return expected.isAssignableFrom(actual);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(actual.getSimpleName() + " must implement " + expected.getSimpleName());
            }
        };
    }
}
