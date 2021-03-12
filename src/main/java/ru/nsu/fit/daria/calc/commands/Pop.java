package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import ru.nsu.fit.daria.calc.Command;

public class Pop implements Command {
    @Override
    @StackSize(1)
    public void execute(String[] args, CalcContext ctx) {
        ctx.getStack().pop();
    }
}
