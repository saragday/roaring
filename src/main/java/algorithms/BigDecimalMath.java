package algorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalMath {

    private static final BigDecimal TWO = BigDecimal.valueOf(2L);
    private static final BigDecimal error = new BigDecimal("0.000000001");

    /**
     * Using Newton's method https://www.zhihu.com/question/20690553
     * @param bd
     * @return
     */
    public static BigDecimal sqrtB(BigDecimal bd) {
        BigDecimal initial = bd;
        BigDecimal diff;
        do {
            BigDecimal sDivX = bd.divide(initial, 8, RoundingMode.FLOOR);
            BigDecimal sum = sDivX.add(initial);
            BigDecimal div = sum.divide(TWO, 8, RoundingMode.FLOOR);
            diff = div.subtract(initial).abs();
            diff.setScale(8, RoundingMode.FLOOR);
            initial = div;
        } while (diff.compareTo(error) > 0);
        return initial;
    }

    public static void main(String[] args) {
        BigDecimal sqrt = sqrtB(new BigDecimal("7"));
        System.out.printf(sqrt.toString());
    }
}
