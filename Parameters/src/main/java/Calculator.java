public class Calculator {

    public int squareInteger(Integer i) {
        i = verifySquaredArgument(i);
        return i * i;
    }

    private Integer verifySquaredArgument(Integer i) {
        if (i == null) {
            return 0;
        }
        if (i > 46340 || i < -46340) {
            throw new IllegalArgumentException("Calculator cannot accept value: " + i);
        }
        return i;
    }
}
