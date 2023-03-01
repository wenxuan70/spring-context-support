package com.alibaba.spring.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.util.ObjectUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link AnnotatedBeanDefinitionRegistryUtils} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see AnnotatedBeanDefinitionRegistryUtils
 * @since 2017.01.13
 */
public class AnnotatedBeanDefinitionRegistryUtilsTest {

    private DefaultListableBeanFactory registry = null;

    @BeforeEach
    public void init() {
        registry = new DefaultListableBeanFactory();
        registry.setAllowBeanDefinitionOverriding(false);
        AnnotationConfigUtils.registerAnnotationConfigProcessors(registry);
    }

    @Test
    public void testRegisterBeans() {

        for(int i=0;i<100;i++) {
            AnnotatedBeanDefinitionRegistryUtils.registerBeans(registry, this.getClass());
        }

        String[] beanNames = registry.getBeanNamesForType(this.getClass());

        assertEquals(1, beanNames.length);

        beanNames = registry.getBeanNamesForType(AnnotatedBeanDefinitionRegistryUtils.class);

        assertTrue(ObjectUtils.isEmpty(beanNames));

        AnnotatedBeanDefinitionRegistryUtils.registerBeans(registry);

    }

    @Test
    public void testScanBasePackages() {

        int count = AnnotatedBeanDefinitionRegistryUtils.scanBasePackages(registry, getClass().getPackage().getName());

        assertEquals(5, count);

        String[] beanNames = registry.getBeanNamesForType(TestBean.class);

        assertEquals(1, beanNames.length);

        beanNames = registry.getBeanNamesForType(TestBean2.class);

        assertEquals(1, beanNames.length);

        count = AnnotatedBeanDefinitionRegistryUtils.scanBasePackages(registry);

        assertEquals(0, count);
    }

}
