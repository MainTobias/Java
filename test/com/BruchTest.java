package com;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


class BruchTest {

    @Nested
    class Ggt {

        @ParameterizedTest(name = "ggT({0}, {1}) = 0")
        @CsvSource({
                "3, 0",
                "0, 3"})
        public void one0_0(int a, int b) {
            long result = Bruch.kgV(a, b);

            assertEquals(0, result);
        }

        @ParameterizedTest(name = "ggT({0}, {1}) = {2}")
        @CsvSource({
                "-12234, 2445, 3",
                "12234, -2445, 3",
                "-3, 4, 1",
                "-12, 4, 4"})
        public void oneNegative_ggTOfAbs(long a, long b, long expected) {
            long result = Bruch.ggT(a, b);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "ggT({0}, {1}) = {2}")
        @CsvSource({
                "72, 96, 24",
                "96, 72, 24",
                "37, 11, 1"})
        public void bothPositive_ggT(long a, long b, long expected) {
            long result = Bruch.ggT(a, b);

            assertEquals(expected, result);
        }

        @Test
        public void relativePrimes_1() {
            long result = Bruch.ggT(3, 5);
            assertEquals(1, result);
        }

        @ParameterizedTest(name = "ggT({0}, {1}) = 123")
        @CsvSource({
                "123, 0",
                "0, 123"})
        public void oneZero_otherNumber(long a, long b) {
            long result = Bruch.ggT(a, b);
            assertEquals(123, result);
        }

        @Test
        public void bothZero_exception() {
            assertThrows(IllegalArgumentException.class, () -> Bruch.ggT(0, 0));
        }
    }

    @Nested
    class Constructor {
        @Test
        public void noArgs_0() {
            Bruch b = new Bruch();

            assertEquals(0, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void zähler_nenner1() {
            Bruch b = new Bruch(3);

            assertEquals(3, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void zählerNenner_nennerNot0_validBruch() {
            Bruch b = new Bruch(3, 6);

            assertEquals(1, b.nominator);
            assertEquals(2, b.denominator);
        }

        @Test
        public void zählerNenner_zählerPositiveNennerNegative_zählerNegativeNennerPositive() {
            Bruch b = new Bruch(3, -2);

            assertEquals(-3, b.nominator);
            assertEquals(2, b.denominator);
        }

        @Test
        public void zählerNenner_bothNegative_bothPositive() {
            Bruch b = new Bruch(-3, -2);

            assertEquals(3, b.nominator);
            assertEquals(2, b.denominator);
        }

        @Test
        public void zählerNenner_zähler0nennerNot0_nenner1() {
            Bruch b = new Bruch(0, 3);

            assertEquals(0, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void double_result() {
            Bruch b = new Bruch(-12.45);

            assertEquals(-249, b.nominator);
            assertEquals(20, b.denominator);
        }

        @Test
        public void zählerNenner__nenner0_exception() {
            String errormsg = assertThrows(IllegalArgumentException.class, () -> new Bruch(1, 0)).getMessage();
            assertTrue(errormsg.contains("Nenner") && errormsg.contains("0"));
        }

        @ParameterizedTest
        @CsvSource({
                "3, 3",
                "-3, -3"
        })
        public void string_int_nenner1(String zähler, int expectedZähler) {
            Bruch b = new Bruch(zähler);

            assertEquals(expectedZähler, b.nominator);
            assertEquals(1, b.denominator);
        }

        @ParameterizedTest
        @CsvSource({
                "56.25, 225, 4",
                "-79.008, -9876, 125"
        })
        public void string_double_objectCreated(String bruch, int expectedZähler, int expectedNenner) {
            Bruch b = new Bruch(bruch);

            assertEquals(expectedZähler, b.nominator);
            assertEquals(expectedNenner, b.denominator);
        }

        @ParameterizedTest
        @CsvSource({
                "72/96, 3, 4",
                "-20/3, -20, 3"
        })
        public void string_fraction_objectCreated(String bruch, int expectedZähler, int expectedNenner) {
            Bruch b = new Bruch(bruch);

            assertEquals(expectedZähler, b.nominator);
            assertEquals(expectedNenner, b.denominator);
        }

        @Test
        public void string_zähler0nennerNot0_nenner1() {
            Bruch b = new Bruch("0/3");

            assertEquals(0, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void string_leadingPoint_valid() {
            Bruch b = new Bruch(".1");

            assertEquals(1, b.nominator);
            assertEquals(10, b.denominator);
        }

        @ParameterizedTest
        @ValueSource(strings = {"text", "-", "3.", "3/-2", "3/+2", "3/a", "2/3a", "a/3", "3/0"})
        public void string_invalidString_exception(String input) {
            assertThrows(IllegalArgumentException.class, () -> new Bruch(input));
        }
    }

    @Nested
    class Mult {

        @Test
        public void null_exception() {
            Bruch b = new Bruch(1);

            assertThrows(IllegalArgumentException.class, () -> b.mult(null));
        }

        @Test
        public void anyBruch_callerUnchanged() {
            Bruch b = new Bruch(2, 3);

            b.mult(new Bruch(3, 7));

            assertEquals(2, b.nominator);
            assertEquals(3, b.denominator);
        }

        @Test
        public void anyBruch_result() {
            Bruch b = new Bruch(4, 5);
            Bruch factor = new Bruch(3, 7);

            Bruch result = b.mult(factor);

            assertEquals(12, result.nominator);
            assertEquals(35, result.denominator);
        }
    }

    @Nested
    class MultThis {

        @Test
        public void null_callerUnchanged() {
            Bruch b = new Bruch(1);

            b.multThis(null);

            assertEquals(1, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void anyBruch_callerChanged() {
            Bruch b = new Bruch(4, 5);
            Bruch subtrahend = new Bruch(3, 7);

            b.subThis(subtrahend);

            assertEquals(13, b.nominator);
            assertEquals(35, b.denominator);
        }
    }

    @Nested
    class Div {

        @Test
        public void _0_exception() {
            Bruch b = new Bruch(3, 5);
            Bruch divisor = new Bruch(0);

            String errorMsg = assertThrows(IllegalArgumentException.class, () -> b.div(divisor)).getMessage();
            assertTrue(errorMsg.contains("0"));
        }

        @Test
        public void null_exception() {
            Bruch b = new Bruch(1);

            assertThrows(IllegalArgumentException.class, () -> b.div(null));
        }

        @Test
        public void anyBruchNot0_callerUnchanged() {
            Bruch b = new Bruch(2, 3);

            b.div(new Bruch(3, 7));

            assertEquals(2, b.nominator);
            assertEquals(3, b.denominator);
        }


        @Test
        public void anyBruchNot0_result() {
            Bruch b = new Bruch(3, 5);
            Bruch divisor = new Bruch(2, 7);

            Bruch result = b.div(divisor);

            assertEquals(21, result.nominator);
            assertEquals(10, result.denominator);
        }
    }

    @Nested
    class DivThis {

        @Test
        public void null_callerUnchanged() {
            Bruch b = new Bruch(1);

            b.divThis(null);

            assertEquals(1, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void _0_exception() {
            Bruch b = new Bruch(3, 5);
            Bruch divisor = new Bruch(0);

            String errorMsg = assertThrows(IllegalArgumentException.class, () -> b.divThis(divisor)).getMessage();
            assertTrue(errorMsg.contains("0"));
        }

        @Test
        public void anyBruch_callerChanged() {
            Bruch b = new Bruch(3, 5);
            Bruch divisor = new Bruch(2, 7);

            b.divThis(divisor);

            assertEquals(21, b.nominator);
            assertEquals(10, b.denominator);
        }
    }

    @Nested
    class Hoch {

        @Test
        public void anyBruchNot0anyExponent_callerUnchanged() {
            Bruch b = new Bruch(2, 3);

            b.hoch(3);

            assertEquals(2, b.nominator);
            assertEquals(3, b.denominator);
        }

        @Test
        public void anyBruchNot0anyExponent_result() {
            Bruch b = new Bruch(3, 5);

            Bruch result = b.hoch(3);

            assertEquals(27, result.nominator);
            assertEquals(125, result.denominator);
        }

        @Test
        public void bruch0negativeExponent_exception() {
            Bruch b = new Bruch(0);

            assertThrows(IllegalArgumentException.class, () -> b.hoch(-1));
        }
    }

    @Nested
    class HochThis {

        @Test
        public void anyBruch_callerChanged() {
            Bruch b = new Bruch(3, 5);

            b.hochThis(-3);

            assertEquals(125, b.nominator);
            assertEquals(27, b.denominator);
        }

        @Test
        public void bruch0negativeExponent_exception() {
            Bruch b = new Bruch(0);

            assertThrows(IllegalArgumentException.class, () -> b.hochThis(-1));
        }
    }

    @Nested
    class ToString {
        private Locale locale;

        @BeforeEach
        public void saveLocale() {
            locale = Locale.getDefault();
        }

        @AfterEach
        public void resetLocale() {
            Locale.setDefault(locale);
        }

        @Test
        public void bruchFormat_Bruchdarstellung() {
            Bruch b = new Bruch("2/4");
            Bruch.setBruchFormat(true);

            assertEquals("1/2", b.toString());
        }

        @Test
        public void dezimalFormatLocaleGerman_kommadarstellung() {
            Bruch.setBruchFormat(false);
            Locale.setDefault(Locale.GERMAN);
            Bruch b = new Bruch("2/4");

            assertEquals("0,500", b.toString());
        }

        @Test
        public void dezimalFormatLocaleUS_kommadarstellung() {
            Bruch.setBruchFormat(false);
            Locale.setDefault(Locale.US);
            Bruch b = new Bruch("2/4");

            assertEquals("0.500", b.toString());
        }

        @Test
        public void dezimalFormat_kommadarstellung() {
            Bruch.setBruchFormat(false);
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            format.setMinimumFractionDigits(3);
            Bruch b = new Bruch(1, 10_000);
            String expected = format.format(0);

            assertEquals(expected, b.toString());
        }

        @Test
        public void bruchFormat_bruchdarstellung() {
            Bruch.setBruchFormat(true);
            Bruch b = new Bruch(2, -100_000);

            assertEquals("-1/50000", b.toString());
        }
    }

    @Nested
    class SubThis {

        @Test
        public void null_callerUnchanged() {
            Bruch b = new Bruch(1);

            b.subThis(null);

            assertEquals(1, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void nennerFremderBruch_callerChanged() {
            Bruch b = new Bruch(4, 5);
            Bruch subtrahend = new Bruch(3, 7);

            b.subThis(subtrahend);

            assertEquals(13, b.nominator);
            assertEquals(35, b.denominator);
        }
    }

    @Nested
    class Sub {

        @Test
        public void null_exception() {
            Bruch b = new Bruch(1);

            assertThrows(IllegalArgumentException.class, () -> b.sub(null));
        }

        @Test
        public void anyBruch_callerUnchanged() {
            Bruch b = new Bruch(2, 3);

            b.sub(new Bruch(3, 7));

            assertEquals(2, b.nominator);
            assertEquals(3, b.denominator);
        }

        @Test
        public void nennerFremderBruch_result() {
            Bruch b = new Bruch(4, 5);
            Bruch subtrahend = new Bruch(3, 7);

            Bruch result = b.sub(subtrahend);

            assertEquals(13, result.nominator);
            assertEquals(35, result.denominator);
        }
    }

    @Nested
    class AddThis {

        @Test
        public void null_callerUnchanged() {
            Bruch b = new Bruch(1);

            b.addThis(null);

            assertEquals(1, b.nominator);
            assertEquals(1, b.denominator);
        }

        @Test
        public void nennerFremderBruch_callerChanged() {
            Bruch b = new Bruch(5, 12);
            Bruch summand = new Bruch(11, 24);

            b.addThis(summand);

            assertEquals(7, b.nominator);
            assertEquals(8, b.denominator);
        }
    }

    @Nested
    class Add {

        @Test
        public void null_exception() {
            Bruch b = new Bruch(1);

            assertThrows(IllegalArgumentException.class, () -> b.add(null));
        }

        @Test
        public void anyBruch_callerUnchanged() {
            Bruch b = new Bruch(2, 3);

            b.add(new Bruch(3, 7));

            assertEquals(2, b.nominator);
            assertEquals(3, b.denominator);
        }

        @Test
        public void nennerFremderBruch_result() {
            Bruch b = new Bruch(5, 12);
            Bruch summand = new Bruch(11, 24);

            Bruch result = b.add(summand);

            assertEquals(7, result.nominator);
            assertEquals(8, result.denominator);
        }
    }

    @Nested
    class Kgv {

        @ParameterizedTest(name = "kgV({0}, {1}) = {2}")
        @CsvSource({
                "1234, -64, 39488",
                "-1234, 64, 39488",
                "-3, 4, 12",
                "-12, 9, 36"})
        public void oneNegative_kgVOfAbs(int a, int b, int expected) {
            long result = Bruch.kgV(a, b);

            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "kgV({0}, {1}) = {2}")
        @CsvSource({
                "12134, 624, 3785808",
                "0, 64, 0",
                "0, 23, 0",
                "3, 4, 12",
                "11, 12, 132"
        })
        public void bothPositive_kgV(int a, int b, int expected) {
            long result = Bruch.kgV(a, b);

            assertEquals(expected, result);
        }

        @Test
        public void both0_exception() {
            assertThrows(IllegalArgumentException.class, () -> Bruch.kgV(0, 0));
        }
    }
}