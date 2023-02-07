package org.example.Lesson4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExampleTest {
    @Test
    void assertExample(){
        assertThat(Functions.isPalindrome("1234521")).isFalse();
        assertThat(6).isLessThan(10).isGreaterThan(0);
        //проверка, что 6 меньше чем 10, и больше чем 0

    }

}
