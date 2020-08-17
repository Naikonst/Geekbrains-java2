package ru.geekbrains.tests;

import org.junit.Test;
import ru.geekbrains.homework.ArrayUtils;

public class ArrayUtilsExcp {

    @Test(expected = RuntimeException.class)
    public void testArraySplitException() {
        int[] array = new int[]{1, 1, 2};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.splitArray(array);
    }

}
