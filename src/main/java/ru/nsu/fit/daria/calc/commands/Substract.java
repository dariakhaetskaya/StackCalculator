package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import ru.nsu.fit.daria.calc.Command;

import java.util.Deque;

public class Substract implements Command {
    @Override
    @StackSize(2)
    public void execute(String[] args, CalcContext ctx) {
        Deque<Double> stack = ctx.getStack();
        var v1 = stack.removeFirst();
        var v2 = stack.removeFirst();
        stack.add(v1 - v2);
    }
}
