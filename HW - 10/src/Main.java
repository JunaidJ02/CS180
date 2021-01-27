public class Main {
    public static void main(String[] args) {
        ComplexNumber operandOne = new ComplexNumber(-37563.572359, 82.375721);
        ComplexNumber operandThree = new ComplexNumber(55712.460984, 472.561980);
        ComplexNumber operandTwo = operandOne.divide(operandThree);

        System.out.println(operandTwo); // 0.007197080824087247
    }
}
