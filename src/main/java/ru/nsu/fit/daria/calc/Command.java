package ru.nsu.fit.daria.calc;

import java.util.Map;
import java.util.Stack;

public interface Command {
    void execute(String[] args, CalcContext ctx);
}
