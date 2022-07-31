package EvenOddJavaThreading.java;

public class Main {
    public static void main(String[] args) {
        final State state = new State(PrinterType.ODD);

        Printer oddPrinter = new Printer(1, 2, 50, state, PrinterType.ODD, PrinterType.EVEN);
        Printer evenPrinter = new Printer(2, 2, 50, state, PrinterType.EVEN, PrinterType.ODD);

        final Thread oddThread = new Thread(oddPrinter);
        final Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();
    }
}
