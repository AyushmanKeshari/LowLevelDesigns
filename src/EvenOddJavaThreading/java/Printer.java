package EvenOddJavaThreading.java;

import lombok.NonNull;

public class Printer implements Runnable {

    private int currValue;
    private final int step;
    private final int maxValue;
    private final State state;
    private final PrinterType currPrinterType;
    private final PrinterType nextPrinterType;

    public Printer(int startValue, @NonNull final int step, @NonNull final int maxValue
            , @NonNull final State state, @NonNull final PrinterType currPrinterType
            , @NonNull final PrinterType nextPrinterType) {
        this.step = step;
        this.maxValue = maxValue;
        this.state = state;
        this.currPrinterType = currPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.currValue = startValue;
    }


    @Override
    public void run() {
        while (currValue <= maxValue) {
            synchronized (state) {
                while (this.currPrinterType != state.getNextToPrint()){
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(currPrinterType + ": " + currValue);
                currValue += step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }
    }
}
