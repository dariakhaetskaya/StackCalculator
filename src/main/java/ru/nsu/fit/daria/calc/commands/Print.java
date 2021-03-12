package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import ru.nsu.fit.daria.calc.Command;

public class Print implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        System.out.println(ctx.getStack().getFirst());
    }
}
