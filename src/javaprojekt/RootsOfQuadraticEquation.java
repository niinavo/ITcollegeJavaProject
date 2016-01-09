package javaprojekt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for calculating roots of quadratic equation (a*x*x+b*x+c=0)
 * (i. e. for implementing quadratic formula)
 * if coefficients of equation 'a', 'b' and 'c' are given.
 * Only case of real-number solutions (roots) of equation is considered.
 */

public class RootsOfQuadraticEquation {

    /**
     * Calculate roots of quadratic equation a*x*x+b*x+c=0.
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return Roots of quadratic equation (two values). Note that two
     *     solutions are always provided for quadratic equations even if they are
     *     the same.
     */
    public static List<BigDecimal> calculateSolutionsOfEquation(
            BigDecimal a, BigDecimal b, BigDecimal c){
        List<BigDecimal> solutions=new ArrayList<>();
        // checking if equation is not quadratic or not linear
        if (b.compareTo(BigDecimal.ZERO)==0 && a.compareTo(BigDecimal.ZERO)==0){
            throw new NumberFormatException("at least one of coefficients of x terms must not be equal to 0");
        // checking if equation is linear (). In this case solution of equation is x1= -c/b.
        } else if (a.compareTo(BigDecimal.ZERO)==0){
            solutions.add(c.negate().divide(b,20,BigDecimal.ROUND_UP));
        } else {
            BigDecimal rootX1 =
                    calculateNumeratorWithSubtraction(a, b, c).
                            divide(calculateDenominator(a), 20,RoundingMode.HALF_UP);
            solutions.add(rootX1);
            BigDecimal rootX2 =
                    calculateNumeratorWithAddition(a, b, c).
                            divide(calculateDenominator(a), 20,RoundingMode.HALF_UP);
            solutions.add(rootX2);
        }
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
    private static BigDecimal calculateNumeratorWithSubtraction(
            BigDecimal a, BigDecimal b, BigDecimal c){
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
    private static BigDecimal calculateNumeratorWithAddition(
            BigDecimal a, BigDecimal b, BigDecimal c){
        return b.negate().add(calculateRootOfDiscriminant(a,b,c));
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
            BigDecimal a, BigDecimal b, BigDecimal c){
        BigDecimal sqrt;
        if (calculateDiscriminant(a,b,c).compareTo(BigDecimal.ZERO)<0){
            throw new NumberFormatException("Equation cannot be solved: no roots of equation");
        } else {
            double discriminantDouble=calculateDiscriminant(a,b,c).doubleValue();
            double sqrtDouble=Math.sqrt(discriminantDouble);
            sqrt=new BigDecimal(sqrtDouble);
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
            BigDecimal a, BigDecimal b, BigDecimal c){
        BigDecimal discriminant;
        BigDecimal subtrahend=a.multiply(convertStringToBigDecimal("4")).multiply(c);
        discriminant=b.pow(2).subtract(subtrahend);
        return discriminant;
    }

    /**
     * Calculate denominator of quadratic formula
     * (formula of roots of quadratic equation) (2*a).
     * @param a Coefficient of 'a' from a quadratic equation to be solved.
     * @return Value of denominator in quadratic formula.
     * @throws NumberFormatException is thrown if 0 is provided as coefficient 'a'
     *    because denominator cannot be zero.
     */
    private static BigDecimal calculateDenominator(BigDecimal a){
        if (a.compareTo(BigDecimal.ZERO)==0){
            throw new NumberFormatException("Denominator cannot be equal to zero");
        }
        return a.multiply(convertStringToBigDecimal("2"));
    }
    
    /**
     * Converts String to BigDecimal.
     *@param str String to be converted to BigDecimal.
     *@return The BigDecimal corresponding to the provided String or Double. null
     *     if the conversion cannot be performed.
     */
    public static BigDecimal convertStringToBigDecimal(String str)
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
