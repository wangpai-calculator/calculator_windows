package org.wangpai.calculator.model.symbol.operation.junit5;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.wangpai.calculator.exception.CalculatorException;
import org.wangpai.calculator.exception.SyntaxException;
import org.wangpai.calculator.model.symbol.operand.Figure;
import org.wangpai.calculator.model.symbol.operand.Operand;
import org.wangpai.calculator.model.symbol.operand.RationalNumber;
import org.wangpai.calculator.model.symbol.operation.Operation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @since 2021-7-24
 */
public class Operation_Test {
    private int firstInt = 1;
    private int secondInt = 2;

    /**
     * 注意：JUnit 的注解对 Maven 不起作用。
     * 尽管使用了注解 @Disabled，但这不能保证 Maven 不会运行这个方法。
     * 将去掉方法的访问修饰符 public 就能阻止 Maven 运行此方法
     */
    @Deprecated
    @Disabled
    @Test
    void test_callBestOperation_Figure() throws CalculatorException {
        assertEquals(new Figure(firstInt + secondInt),
                callBestOperation_native("add",
                        new Figure(firstInt), new Figure(secondInt)));
    }

    @Deprecated
    @Disabled
    @Test
    void test_preliminaryCheck_normal() {
        assertDoesNotThrow(() -> preliminaryCheck_native(new Figure(), new Figure()));
    }

    @Deprecated
    @Disabled
    @Test
    void test_preliminaryCheck_exception() {
        Throwable throwable = assertThrows(SyntaxException.class,
                () -> preliminaryCheck_native(new Figure(), null, null));
        assertEquals("错误：第 2 、3 个操作数为 null。", throwable.getMessage());
    }

    @Deprecated
    @Disabled
    @Test
    void test_sortByInheritance_normal() throws CalculatorException {
        // 方法调用时，发生了对形参的交换
        Object[] sortResult = sortByInheritance_native(new Figure(), new RationalNumber());
        assertEquals(RationalNumber.class, sortResult[0].getClass());
        assertEquals(Figure.class, sortResult[1].getClass());
        assertEquals(true, sortResult[2]);

        // 方法调用时，没有发生了对形参的交换
        sortResult = sortByInheritance_native(new RationalNumber(), new Figure());
        assertEquals(RationalNumber.class, sortResult[0].getClass());
        assertEquals(Figure.class, sortResult[1].getClass());
        assertEquals(false, sortResult[2]);
    }

    @Deprecated
    @Disabled
    @Test
    void test_sortByInheritance_exception() {
        var first = new Figure() {
        };
        var second = new Figure() {
        };
        Throwable throwable = assertThrows(SyntaxException.class,
                () -> sortByInheritance_native(first, second));
        assertEquals("错误：这两个操作数之间没有继承关系", throwable.getMessage());
    }

    @Deprecated
    @Disabled
    @Test
    void test_generateExceptionString() {
        HashSet<Integer> exceptionRecords = new HashSet<>();
        for (int order = 1; order < 10; ++order) {
            exceptionRecords.add(order);
        }

        assertEquals(" 1 、2 、3 、4 、5 、6 、7 、8 、9 ",
                generateExceptionString_native(exceptionRecords).toString());
    }

    /*---------------模拟的原生待测方法---------------*/

    Operand callBestOperation_native(
            String methodName, Operand first, Operand second)
            throws CalculatorException {
        Operand result;
        try {
            var methodToBeTested = Operation.class
                    .getDeclaredMethod("callBestOperation",
                            String.class, Operand.class, Operand.class);
            methodToBeTested.setAccessible(true);
            result = (Operand) methodToBeTested.invoke(
                    null, methodName, first, second);
        } catch (NoSuchMethodException | InvocationTargetException
                | IllegalAccessException exception) {
            Throwable realException = exception.getCause();
            throw (CalculatorException) realException;
        }

        return result;
    }

    void preliminaryCheck_native(Operand... operands) throws SyntaxException {
        try {
            /**
             * 将可变参数视为数组参数，且需要将数组再封装到一个 Object[] 中
             */
            var methodToBeTested = Operation.class.getDeclaredMethod(
                    "preliminaryCheck", Operand[].class);
            methodToBeTested.setAccessible(true);
            methodToBeTested.invoke(null, new Object[]{operands});
        } catch (NoSuchMethodException | InvocationTargetException
                | IllegalAccessException exception) {
            Throwable realException = exception.getCause();
            throw (SyntaxException) realException;
        }
    }

    Object[] sortByInheritance_native(Operand first, Operand second)
            throws CalculatorException {
        Object[] result;
        try {
            var methodToBeTested = Operation.class
                    .getDeclaredMethod("sortByInheritance",
                            Operand.class, Operand.class);
            methodToBeTested.setAccessible(true);
            result = (Object[]) methodToBeTested.invoke(
                    null, first, second);
        } catch (NoSuchMethodException | InvocationTargetException
                | IllegalAccessException exception) {
            Throwable realException = exception.getCause();
            throw (CalculatorException) realException;
        }

        return result;
    }

    StringBuilder generateExceptionString_native(HashSet<Integer> exceptionRecords) {
        StringBuilder result = null;
        try {
            var methodToBeTested = Operation.class
                    .getDeclaredMethod("generateExceptionString",
                            HashSet.class);
            methodToBeTested.setAccessible(true);
            result = (StringBuilder) methodToBeTested.invoke(
                    null, exceptionRecords);
        } catch (NoSuchMethodException | InvocationTargetException
                | IllegalAccessException exception) {
            // 因为原方法没有抛出异常，所以这里什么也不用干
        }

        return result;
    }

    /****************模拟的原生待测方法****************/

}
