package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import ru.nsu.fit.daria.calc.Command;

public class Push implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        if (Character.isAlphabetic(args[1].charAt(0))){
            ctx.getStack().add(ctx.getConstants().get(args[1]));
        } else {
            ctx.getStack().add(Double.valueOf(args[1]));
        }

    }
}
