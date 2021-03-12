package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.daria.calc.CalcExeption;
import ru.nsu.fit.daria.calc.CommandFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAdd {
    @Test
    public void testAdd() throws CalcExeption {
        CommandFactory factory = CommandFactory.getInstance();
        CalcContext ctx = new CalcContext();
        var cmd = factory.findCommandByName("+");
        ctx.getStack().add(100.0);
        ctx.getStack().add(224.0);
        cmd.execute(null, ctx);
        assertEquals(324, ctx.getStack().pop());
    }

    @Test
    public void testAddEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalcContext ctx = new CalcContext();
        var cmd = factory.findCommandByName("+");
        assertThrows(CalcExeption.class, () -> cmd.execute(null, ctx));
    }

    @Test
    public void testAddNotEnoughArgs(){
        CommandFactory factory = CommandFactory.getInstance();
        CalcContext ctx = new CalcContext();
        var cmd = factory.findCommandByName("+");
        ctx.getStack().add(100.0);
        assertThrows(CalcExeption.class, () -> cmd.execute(null, ctx));
    }
}
