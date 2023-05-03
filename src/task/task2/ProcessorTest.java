package task.task2;

import java.util.ArrayList;
import java.util.List;

public class ProcessorTest {

    public boolean fizz(int i){
        if (i % 3 == 0 && i % 5 != 0) {
            return true;
        }
        return  false;
    }

    public boolean buzz(int i){
        if (i % 5 == 0 && i % 3 != 0) {
             return true;
        }
        return  false;
    }

    public boolean fizzbuzz(int i){
        if (i % 3 == 0 && i % 5 == 0) {
            return true;
        }
        return  false;
    }

    public void number(int i) {
            System.out.print(i + ", ");
     }


    public static void main(String[] args) {

        ProcessorTest processorTest = new ProcessorTest();

        ProcessThread A = new ProcessThread((n) -> {
            processorTest.fizz(n);
        });
        ProcessThread B = new ProcessThread((n) -> {
            processorTest.buzz(n);
        });
        ProcessThread C = new ProcessThread((n) -> {
            processorTest.fizzbuzz(n);
        });
        ProcessThread D = new ProcessThread((n) -> {
            if (processorTest.fizz(n)) {
                System.out.print("fizz, ");
            } else if (processorTest.buzz(n)) {
                System.out.print("buzz, ");
            } else if (processorTest.fizzbuzz(n)) {
                System.out.print("fizzbuzz, ");
            } else {
                processorTest.number(n);
            }
        });

        List<ProcessThread> threads = new ArrayList<>();
        threads.add(C);
        threads.add(A);
        threads.add(B);
        threads.add(D);

        for (ProcessThread thread : threads) {
            thread.start();
        }

        for (int i = 1; i < 41; i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }

            while (true) {
                int processedCount = 0;
                for (ProcessThread thread : threads) {
                    if(thread.getIsProcessed().get()) {
                        processedCount++;
                    }
                }
                if (processedCount == threads.size()) {
                    break;
                }
            }
        }
        System.exit(0);
    }
}
