package org.example.Lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.Lesson4.Functions.isPalindrome;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");



     @BeforeAll
     static void beforeAll(){
         logger.info("метод выполнится 1 раз перед всеми тестами");


    }

    //TRACE, DEBUG, WARN, INFO, ERROR -уровни логирования


    @BeforeEach
    void beforeEach(){
        logger.error("метод выполнится перед каждым тестом");

    }


    @Test
    @DisplayName("Метод проверки палиндрома с нечетным колвом символов, переданного в метод isPalindrome")
    void givenPalindromeMethodThenTrue() {
        //boolean result = isPalindrome("1234321");
       // Assertions.assertTrue(result);
        assertThat(isPalindrome("1234321")).isTrue(); //проверка, что это палиндром
        //Assertions.assertEquals(true, result);


    }

    @ParameterizedTest
    @ValueSource(strings = {"1234321", "123321"})
    void isPalindromeTestWithDataProvider(String word){
         boolean result = isPalindrome(word);
         Assertions.assertTrue(result);

    }

    @ParameterizedTest
    @CsvSource({"123, false", "123321, true"})
    void csvTest(String word, boolean expectedResult){
         boolean actualResult = isPalindrome(word);
         Assertions.assertEquals(expectedResult, actualResult);

    }

    @ParameterizedTest
    @Tag("smoke")
    @MethodSource("catAndAgeDataProvider")
void catEqualsAgeTest(Cat cat, Integer age){
         Assertions.assertEquals(cat.getAge(), age);

    }

    private static Stream<Arguments>catAndAgeDataProvider(){
         return Stream.of(
                 Arguments.of(new Cat("Barsik", 10),10),
                 Arguments.of(new Cat("Chika", 9),9),
                 Arguments.of(new Cat("Kotik", 12),12)
         );

    }

    @Test
    @DisplayName("Метод проверки палиндрома c четным количеством символов, переданного в метод isPalindrome")
    void givenPalindromeMethodThenTrue1() {
        boolean result = isPalindrome("123321");
        Assertions.assertTrue(result);
        //Assertions.assertEquals(true, result);
    }

    @AfterEach
    void afterEach(){
        System.out.println("метод выполнится после каждого теста");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("метод выполнится 1 раз после всех тестов");

    }

}