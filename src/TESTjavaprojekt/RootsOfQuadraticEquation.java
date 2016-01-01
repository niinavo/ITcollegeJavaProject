package TESTjavaprojekt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for calculating roots of quadratic equation (a*x*x+b*x+c=0)
 * (i. e. for implementing quadratic formula)
 * if coefficients of equation 'a', 'b' and 'c' are given
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
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        final List<BigDecimal> solutions=new ArrayList<>();
        // checking if equation is not quadratic or not linear
        if (b.compareTo(BigDecimal.ZERO)==0 && a.compareTo(BigDecimal.ZERO)==0){
            throw new NumberFormatException("at least one of coefficients of x terms must not be equal to 0");
        // checking if equation is linear. In this case solution of equation is x1= -c/b.
        } else if (a.compareTo(BigDecimal.ZERO)==0){
            solutions.add(c.negate().divide(b,20,BigDecimal.ROUND_UP));
        } else {
            final BigDecimal rootX1 =
                    calculateNumeratorWithAddition(a, b, c).
                            divide(calculateDenominator(a), 20,RoundingMode.HALF_UP);
            solutions.add(rootX1);
            final BigDecimal rootX2 =
                    calculateNumeratorWithSubtraction(a, b, c).
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
    public static BigDecimal calculateNumeratorWithSubtraction(
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
    public static BigDecimal calculateNumeratorWithAddition(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
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
    public static BigDecimal calculateRootOfDiscriminant(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        BigDecimal sqrt;
        if (calculateDiscriminant(a,b,c).compareTo(BigDecimal.ZERO)<0){
            throw new NumberFormatException("Equation cannot be solved: no roots of equation");
        } else {
            final double discriminantDouble=calculateDiscriminant(a,b,c).doubleValue();
            final double sqrtDouble=Math.sqrt(discriminantDouble);
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
    public static BigDecimal calculateDiscriminant(
            final BigDecimal a, final BigDecimal b, final BigDecimal c){
        final BigDecimal discriminant;
        final BigDecimal subtrahend=a.multiply(QuadraticEquationCalculator.convertStringToBigDecimal("4")).multiply(c);
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
    public static BigDecimal calculateDenominator(final BigDecimal a){
        if (a.compareTo(BigDecimal.ZERO)==0){
            throw new NumberFormatException("Denominator cannot be equal to zero");
        }
        return a.multiply(QuadraticEquationCalculator.convertStringToBigDecimal("2"));
    }
}
