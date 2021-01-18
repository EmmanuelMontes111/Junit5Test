package junit5;

public class Calculator {

    private int result;
    public int add(int n1, int n2){
        result = n1 +n2;
        return result;
    }


    public int subtract(int n1, int n2){
        result = n1 - n2;
        return  result;
    }

    public int divide(int numero1, int numero2) {
        if (numero2 == 0){
            throw new ArithmeticException("No se puede dividir por cero");
        }
        result = numero1 / numero2;
        return result;
    }

}
