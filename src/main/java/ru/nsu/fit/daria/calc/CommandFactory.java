package ru.nsu.fit.daria.calc;

import ru.nsu.fit.daria.calc.commands.StackSize;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {

    private static class Helper {
        private static final CommandFactory factory = new CommandFactory();
    }

    private final Map<String, Command> commands = new HashMap<>();

    public static CommandFactory getInstance() {
        return Helper.factory;
    }

    private CommandFactory() {
        try(var in = Main.class.getResourceAsStream("commands.properties")){
            Properties props = new Properties();
            props.load(in);

            for (var name: props.stringPropertyNames()){
                String clsName = props.getProperty(name);
                Class<?> aClass = Class.forName(clsName);
                var cmd = (Command)aClass.forName(clsName).getDeclaredConstructor().newInstance();
                StackSize stackSize =  aClass.getMethod("execute", String[].class, CalcContext.class).getAnnotation(StackSize.class);

                Command proxyCommand = new Command() {
                    @Override
                    public void execute(String[] args, CalcContext ctx) throws  CalcExeption {
                        if (stackSize != null && stackSize.value() > ctx.getStack().size()){
                            throw new CalcExeption(name + " expects at least " + stackSize.value() + " elements in stack");
                        }
                        cmd.execute(args, ctx);
                    }
                };
                commands.put(name, proxyCommand);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Command findCommandByName(String name){
        return commands.get(name);
    }
}
