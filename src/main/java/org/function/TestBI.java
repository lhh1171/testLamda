package org.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestBI {
    public static void main(String[] args) {
        compute1(5, value -> value * value); //25 计算平方
        compute1(5, value -> value + value); //25 计算jia
        compute1(5, value -> value - 1); //25 计算jian
        System.out.println(compute2(2, value -> value * 3, value -> value * value));//2*2*3
        System.out.println(compute3(2, value -> value * 3, value -> value * value));//2*3*2*3
        compute4(2, 3, (v1, v2) -> v1 + v2); //5
        compute4(2, 3, (v1, v2) -> v1 - v2) ;//-1
        compute4(2, 3, (v1, v2) -> v1 * v2) ;//6
        compute5(2, 3, (v1, v2) -> v1 + v2, v1 -> v1 * v1);
    }
    public static int compute1(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }
    public static int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }
    public static int compute3(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    public static int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
    public static int compute5(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
