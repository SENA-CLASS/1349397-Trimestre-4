package co.edu.sena.programming.lesson10.serializable.ejemplo02;

public class StockException extends Exception {
    private static final long serialVersionUID = 103L;
    public StockException (String reason) {
        super (reason);
    }
}
