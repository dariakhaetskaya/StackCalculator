package ru.nsu.fit.daria.calc.commands;

import ru.nsu.fit.daria.calc.CalcContext;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.daria.calc.CalcExeption;
import ru.nsu.fit.daria.calc.CommandFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDefine {
    @Test
    public void testSqrt() throws CalcExeption {
        CommandFactory factory = CommandFactory.getInstance();
        CalcContext ctx = new CalcContext();
        var def = factory.findCommandByName("define");
        var push = factory.findCommandByName("push");
        String[] args = {"define", "pi", "3.14"};
        def.execute(args, ctx);
        push.execute(args, ctx);
        assertEquals(3.14, ctx.getStack().pop());
    }

    @Test
    public void testSqrtNeg() throws CalcExeption {
        CommandFactory factory = CommandFactory.getInstance();
        CalcContext ctx = new CalcContext();
        var cmd = factory.findCommandByName("sqrt");
        ctx.getStack().add(-1024.0);
        assertThrows(CalcExeption.class, () -> cmd.execute(null, ctx));
    }

    @Test
    public void testMulEmpty(){
        CommandFactory factory = CommandFactory.getInstance();
        CalcContext ctx = new CalcContext();
        var cmd = factory.findCommandByName("sqrt");
        assertThrows(CalcExeption.class, () -> cmd.execute(null, ctx));
    }
}
