package ru.nsu.fit.daria.calc;

public class CalcExeption extends Exception {

    public CalcExeption(String message) {
        super(message);
    }

    public CalcExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }

    public CalcExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CalcExeption() {
    }
}
