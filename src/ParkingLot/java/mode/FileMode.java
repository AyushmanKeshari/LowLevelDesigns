package ParkingLot.java.mode;

import ParkingLot.java.OutputPrinter;
import ParkingLot.java.commands.CommandExecutorFactory;
import ParkingLot.java.model.Command;

import java.io.*;

public class FileMode extends Mode {
    String fileName;

    public FileMode(CommandExecutorFactory factory, OutputPrinter outputPrinter, String fileName) {
        super(factory, outputPrinter);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {
        File file = new File(fileName);
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputPrinter.fileNotFound();
            return;
        }

        String input = bufferedReader.readLine();
        while (input != null) {
            Command command = new Command(input);
            processCommand(command);
            input = bufferedReader.readLine();
        }
    }
}
