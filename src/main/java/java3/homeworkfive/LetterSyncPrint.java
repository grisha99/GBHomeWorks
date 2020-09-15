package java3.homeworkfive;

/**
 *
 *Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
 *(порядок – ABСABСABС). Используйте wait/notify/notifyAll
 *
 */

public class LetterSyncPrint {

    private Object threadMonitor;
    private volatile char nextLetter;

    private int charSequence;

    public LetterSyncPrint() {
        threadMonitor = new Object();
        nextLetter = 'A';
    }

    public void startPrint(int count){
        charSequence = count;
        Thread tPrintA = new Thread(() -> {
            this.printA();
        });
        Thread tPrintB = new Thread(() -> {
            this.printB();
        });
        Thread tPrintC = new Thread(() -> {
            this.printC();
        });
        tPrintA.start();
        tPrintB.start();
        tPrintC.start();
    }

    private void printA() {
        synchronized (threadMonitor) {
            for (int i = 0; i < charSequence; i++) {
                while (nextLetter != 'A') {
                    try {
                        threadMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('A');
                nextLetter = 'B';
                threadMonitor.notifyAll();
            }
        }
    }

    private void printB() {
        synchronized (threadMonitor) {
            for (int i = 0; i < charSequence; i++) {
                while (nextLetter != 'B') {
                    try {
                        threadMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('B');
                nextLetter = 'C';
                threadMonitor.notifyAll();
            }
        }
    }

    private void printC() {
        synchronized (threadMonitor) {
            for (int i = 0; i < charSequence; i++) {
                while (nextLetter != 'C') {
                    try {
                        threadMonitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print('C');

                nextLetter = 'A';
                threadMonitor.notifyAll();
            }
        }
    }
}
