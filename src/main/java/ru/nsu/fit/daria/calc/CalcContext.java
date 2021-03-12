package ru.nsu.fit.daria.calc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CalcContext {
    private Deque<Double> stack = new ArrayDeque<Double>();
    private Map<String, Double> consts = new HashMap<>();

    public Deque<Double> getStack() {
        return stack;
    }

    public Map<String, Double> getConstants() {
        return consts;
    }
}
