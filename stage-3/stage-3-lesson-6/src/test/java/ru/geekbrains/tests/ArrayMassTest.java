package ru.geekbrains.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.geekbrains.homework.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayMassTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{5}},
                {new int[]{1, 2, 3, 4}, new int[]{}}
        });
    }

    int[] array;
    int[] arrayExpected;

    public ArrayMassTest(int[] array, int[] arrayExpected) {
        this.array = array;
        this.arrayExpected = arrayExpected;
    }

    @Test
    public void testSplitArrayWithParams() {
        ArrayUtils arrayUtils = new ArrayUtils();
        Assert.assertArrayEquals(arrayExpected, arrayUtils.splitArray(array));
    }
}
