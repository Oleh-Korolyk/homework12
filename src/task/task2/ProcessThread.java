package task.task2;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread{

    private int number;

    private AtomicBoolean isProcessed = new AtomicBoolean(true);

    private NumberProcessor processor;


    public ProcessThread(NumberProcessor processor) {
        this.processor = processor;
    }


    public void process(int number) {
        this.number = number;
        isProcessed.set(false);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isProcessed.get()) {
                continue;
            }

            processor.process(number);
            isProcessed.set(true);
        }
    }

    public AtomicBoolean getIsProcessed() {
        return isProcessed;
    }

}
