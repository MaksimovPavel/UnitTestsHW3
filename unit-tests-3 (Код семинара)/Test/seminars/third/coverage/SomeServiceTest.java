package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService someService;
    @BeforeEach
    void setUp(){
        someService = new SomeService();
    }
   // 3.1.
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        String result = someService.fizzBuzz(3);

        assertThat(result).isEqualTo("Fizz");
    }
    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        String result = someService.fizzBuzz(5);

        assertThat(result).isEqualTo("Buzz");
    }
    @Test
    void multipleFiveAndThreeReturnsFizzBuzz() {
        String result = someService.fizzBuzz(15);

        assertEquals("FizzBuzz", result);
    }
    @Test
    void notMultipleReturnsNum(){
        String result = someService.fizzBuzz(8);

        assertEquals("8",result);
    }
    @Test
    void firstLastTest(){
        int [] newArr = {6,5,6,7,4,3,2,3,7,6};
        boolean result = someService.firstLast6(newArr);

        assertTrue(result);
    }
    @Test
    void firstLastTestFalse(){
        int [] newArr = {6,5,6,7,4,3,2,3,7,1};
        boolean result = someService.firstLast6(newArr);

        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"2000.0,50,1000","2000.0,100,0","2000.0, 0, 2000"})
    void testParameter(Double purchaseAm, int discountAm, int expected){
        assertThat(someService.calculatingDiscount(purchaseAm, discountAm))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource({"2000.0,101","2000.0,-10"})
    void testWrongParameter(Double purchaseAm, int discountAm){
        assertThatThrownBy(() ->
                someService.calculatingDiscount(purchaseAm, discountAm))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }
    @Test
    void testLuckyNum(){
        int x = 1;
        int y = 2;
        int z = 3;

        int result = someService.luckySum(x,y,z);

        assertEquals(6,result);
    }
    @Test
    void evenOddNumberTest(){
        assertThat(someService.evenOddNumber(2)).isTrue();
        assertThat(someService.evenOddNumber(3)).isFalse();
    }
    @Test
    void numberInIntervalTest(){
        assertThat(someService.numberInInterval(50)).isTrue();
        assertThat(someService.numberInInterval(25)).isTrue();
        assertThat(someService.numberInInterval(100)).isTrue();
        assertThat(someService.numberInInterval(101)).isFalse();
    }
}