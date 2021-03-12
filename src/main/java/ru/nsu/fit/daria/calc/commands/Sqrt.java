package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import ru.nsu.fit.daria.calc.CalcExeption;
import ru.nsu.fit.daria.calc.Command;

import java.util.Deque;

public class Sqrt implements Command {
    @Override
    @StackSize(1)
    public void execute(String[] args, CalcContext ctx) throws CalcExeption {
        Deque<Double> stack = ctx.getStack();
        var v1 = stack.removeFirst();
        if (v1 < 0){
            throw new CalcExeption("Can not take square root of a negative number");
        }
        stack.add(Math.sqrt(v1));
    }
}
