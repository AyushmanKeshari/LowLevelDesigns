package EvenOddJavaThreading.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

//Common State Object between two thread.    Can be a Message, Synchronizer

//For Inter-Thread communication    :
//For Thread Synchronization        : It will tell whose turn is now?
public class State {
    private PrinterType nextToPrint;
}
