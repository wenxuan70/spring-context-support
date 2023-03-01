package com.alibaba.spring.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.PropertyValues;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link PropertyValuesUtils} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see PropertyValuesUtils
 * @since 2017.01.13
 */
public class PropertyValuesUtilsTest {

    @Test
    public void testGetSubPropertyValues() {

        MockEnvironment environment = new MockEnvironment();

        PropertyValues propertyValues = PropertyValuesUtils.getSubPropertyValues(environment, "user");

        assertNotNull(propertyValues);

        assertFalse(propertyValues.contains("name"));
        assertFalse(propertyValues.contains("age"));

        environment.setProperty("user.name", "Mercy");
        environment.setProperty("user.age", "30");

        propertyValues = PropertyValuesUtils.getSubPropertyValues(environment, "user");

        assertEquals("Mercy", propertyValues.getPropertyValue("name").getValue());
        assertEquals("30", propertyValues.getPropertyValue("age").getValue());

    }

}
