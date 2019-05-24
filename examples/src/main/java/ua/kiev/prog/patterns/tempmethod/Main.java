package ua.kiev.prog.patterns.tempmethod;

public class Main {
    public static void main(String[] args) {
        TransactionMethod method = new OnlineTransaction();
        method.perform();

        method = new AtmTransaction();
        method.perform();
    }
}
