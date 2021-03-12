package ru.nsu.fit.daria.calc;

import org.apache.commons.cli.*;
import java.io.*;

public class Main {

    public static void main(String[] args){
        Options options = new Options();
        options.addOption("f", "file", true,"Input file");
        CommandLineParser parser = new DefaultParser();
        InputStream in = System.in;
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("help")){
                return;
            }
            if (line.hasOption("file")){
                String file = line.getOptionValue("file");
                System.out.println("Reading from " + file);
                in = new FileInputStream(file);
            }

        } catch (ParseException | FileNotFoundException exp) {
            System.err.println("Parsing failed. Reason: " + exp.getMessage());
        }

        CalcContext ctx = new CalcContext();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            CommandFactory factory = CommandFactory.getInstance();
            String arg;
            while ( null != (arg = reader.readLine()) && !arg.isEmpty()) {
                if (arg.startsWith("#")){
                    continue;
                }
                var cmaArgs = arg.split(" ");
                var cmd = factory.findCommandByName(cmaArgs[0]);
                if (cmd == null){
                    System.out.println("Command not found");
                    continue;
                }
                cmd.execute(cmaArgs, ctx);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (CalcExeption calcExeption) {
            calcExeption.printStackTrace();
        }
    }

}
