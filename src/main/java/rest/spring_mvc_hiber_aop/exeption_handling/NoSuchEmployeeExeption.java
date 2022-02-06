package rest.spring_mvc_hiber_aop.exeption_handling;

public class NoSuchEmployeeExeption extends RuntimeException {

    public NoSuchEmployeeExeption(String message) {
        super(message);
    }
}
