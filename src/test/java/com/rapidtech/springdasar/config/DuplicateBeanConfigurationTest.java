package com.rapidtech.springdasar.config;

import com.rapidtech.springdasar.model.Foo;
import com.rapidtech.springdasar.model.TryBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateBeanConfigurationTest {
    @Test
    void beanTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateBeanConfiguration.class);

        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);
        Assertions.assertNotSame(foo1, foo2);

        Foo foo3 = context.getBean("foo1", Foo.class);
        Assertions.assertSame(foo1, foo3);

        Foo foo4 = context.getBean("foo2", Foo.class);
        Assertions.assertSame(foo4, foo4);


    }
}