package javaprojekt;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for calculating roots of quadratic equation (a*x*x+b*x+c=0)
 * (i. e. for implementing quadratic formula)
 * if coefficients of equation 'a', 'b' and 'c' are given
 */

public class Test_ {
    /** Default precision used for specifying scale. */
    private static final int DEFAULT_PRECISION = MathContext.DECIMAL64.getPrecision();

    /** Representation of two as BigDecimal. */
    private static final BigDecimal TWO = new BigDecimal("2");

    /** Representation of four as BigDecimal. */
    private static final BigDecimal FOUR = new BigDecimal("4");

    public static void main(String[] args) {
        //System.out.println(new BigDecimal("xx"));
        //System.out.println(convertStringToBigDecimall("//"));
        BigDecimal a = convertStringToBigDecimall("1");
        BigDecimal b = convertStringToBigDecimall("-1");
        BigDecimal c = convertStringToBigDecimall("6");
        //System.out.println("discriminant="+calculateDiscriminant(a,b,c));
        //System.out.println("root of discriminant="+calculateRootOfDiscriminant(a,b,c));
        //System.out.println("denominator="+calculateDenominator(a));
        //System.out.println("denominator with addition="+calculateDenominatorWithAddition(a,b,c));
        //System.out.println("denominator with substraction="+calculateDenominatorWithSubstraction(a,b,c));
        //System.out.println("solutions="+calculateSolutionsOfEquation(a,b,c));
    }
    /**
     * Converts String to BigDecimal.
     *@param str String to be converted to BigDecimal.
     *@return The BigDecimal corresponding to the provided String or Double.NaN
     *     if the conversion cannot be performed.
     */
    private static BigDecimal convertStringToBigDecimal(String str)
    {
        BigDecimal stringConvertedToNumber;
        try
        {
            stringConvertedToNumber = new BigDecimal(str);
        }
        catch (NumberFormatException nfe)
        {
            stringConvertedToNumber = null;
        }
        return stringConvertedToNumber;
    }


    /**
     * Calculate roots of quadratic equation ax*x+b*x+c=0.
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return Roots of quadratic equation (two values). Note that two
     *     solutions are always provided for quadratic equations even if they are
     *     the same.
     */
    public static List<BigDecimal> calculateSolutionsOfEquation(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        final List<BigDecimal> solutions=new ArrayList<BigDecimal>();
        final BigDecimal rootX1=
                calculateDenominatorWithAddition(a,b,c).
                        divide(calculateDenominator(a), RoundingMode.HALF_UP);
        solutions.add(rootX1);
        final BigDecimal rootX2=
                calculateDenominatorWithSubstraction(a, b, c).
                        divide(calculateDenominator(a),RoundingMode.HALF_UP);
        solutions.add(rootX2);
        return solutions;
    }

    /**
     * Calculate numerator of quadratic formula
     * (formula of roots of quadratic equation) where the terms are subtracted.
     *
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return Value of numerator in quadratic formula where terms are subtracted.
     * @throws NumberFormatException is thrown if no real solution is available.
     */
    private static BigDecimal calculateDenominatorWithSubstraction(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        return b.negate().subtract(calculateRootOfDiscriminant(a,b,c));
    }

    /**
     * Calculate numerator of quadratic formula
     * (formula of roots of quadratic equation) where the terms are added.
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return Value of numerator in quadratic formula where terms are added.
     * @throws NumberFormatException is thrown if no real solution is available.
     */
    private static BigDecimal calculateDenominatorWithAddition(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        return b.negate().add(calculateRootOfDiscriminant(a,b,c));
    }

    /**
     * Calculate denominator of quadratic formula
     * (formula of roots of quadratic equation) (2*a).
     * @param a Coefficient of 'a' from a quadratic equation to be solved.
     * @return Value of denominator in quadratic formula.
     * @throws NumberFormatException is thrown if 0 is provided as coefficient 'a'
     *    because denominator cannot be zero.
     */
    private static BigDecimal calculateDenominator(final BigDecimal a){
        //if (a.compareTo(BigDecimal.ZERO)==0){
        //    throw new NumberFormatException("Denominator cannot be equal to zero");
        //}
        return a.multiply(TWO);
    }

    /**
     * Calculates value of square root of discriminant of quadratic equation.
     *
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return The square root of discriminant of quadratic equation.
     * @throws NumberFormatException is thrown if there is no solutions (roots) to
     * equation or if a number is encountered that cannot
     *    be handled with BigDecimal return type.
     */
    private static BigDecimal calculateRootOfDiscriminant(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        BigDecimal sqrt;
        if (calculateDiscriminant(a,b,c).compareTo(BigDecimal.ZERO)<0){
            throw new NumberFormatException("Equation cannot be solved: no roots of equation");
        } else {
            final double discriminantDouble=calculateDiscriminant(a,b,c).doubleValue();
            final double sqrtDouble=Math.sqrt(discriminantDouble);
            sqrt=new BigDecimal(sqrtDouble); //may throw NumberFormatException
        }

        return sqrt;
    }

    /**
     * Calculate value of discriminant of quadratic equation (b*b-4*a*c)
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return The discriminant of quadratic equation if the three coefficients
     * of equation are provided.
     */
     private static BigDecimal calculateDiscriminant(
             final BigDecimal a, final BigDecimal b, final BigDecimal c){
         BigDecimal discriminant;
         final BigDecimal subtrahend=a.multiply(c).multiply(FOUR);
         discriminant=b.pow(2).subtract(subtrahend);
         return discriminant;
     }

    public static BigDecimal convertStringToBigDecimall(String str)
    {
        BigDecimal stringConvertedToNumber;
        try
        {
            stringConvertedToNumber = new BigDecimal(str);
        }
        catch (NumberFormatException nfe)
        {
            stringConvertedToNumber = null;
        }
        return stringConvertedToNumber;
    }

}
