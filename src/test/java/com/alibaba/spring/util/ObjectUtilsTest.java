/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.spring.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.alibaba.spring.util.ObjectUtils.of;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link ObjectUtils} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.2
 */
public class ObjectUtilsTest {

    @Test
    public void testOf() {
        String[] values = of("Hello,World");
        assertTrue(Arrays.deepEquals(values, new String[]{"Hello,World"}));
        assertFalse(Arrays.deepEquals(values, new String[]{"Hello,World   "}));
    }

    @Test
    public void testEmptyArray() {
        String[] array = ObjectUtils.emptyArray(String.class);
        assertEquals(0, array.length);
    }

}
