package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import ru.nsu.fit.daria.calc.Command;

public class Define implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        ctx.getConstants().put(args[1], Double.valueOf(args[2]));
    }
}
