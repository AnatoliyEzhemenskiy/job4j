package ru.job4j.coffeemachine;

public class NoMoneyException extends RuntimeException {
    public NoMoneyException (String msg) {
        super(msg);
    }
}
