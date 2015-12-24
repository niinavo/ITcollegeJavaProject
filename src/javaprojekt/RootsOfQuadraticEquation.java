package javaprojekt;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Class for calculating roots of quadratic equation (a*x*x+b*x+c=0)
 * (i. e. for implementing quadratic formula)
 * if coefficients of equation 'a', 'b' and 'c' are given
 */

public class RootsOfQuadraticEquation {
    /** Default precision used for specifying scale. */
    private static final int DEFAULT_PRECISION = MathContext.DECIMAL64.getPrecision();

    /** Convenient representation of zero as BigDecimal. */
    private static final BigDecimal ZERO = new BigDecimal("0");

    /** Convenient representation of two as BigDecimal. */
    private static final BigDecimal TWO = new BigDecimal("2");

    /** Convenient representation of four as BigDecimal. */
    private static final BigDecimal FOUR = new BigDecimal("4");

    /**
     * Calculate roots of quadratic equation ax*x+b*x+c=0.
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return Roots of quadratic equation (two values). Note that two
     *     solutions are always provided for quadratic equations even if they are
     *     the same.
     */

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

    /**
     * Calculate numerator of quadratic formula
     * (formula of roots of quadratic equation) where the terms are added.
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return Value of numerator in quadratic formula where terms are added.
     * @throws NumberFormatException is thrown if no real solution is available.
     */

    /**
     * Calculate denominator of quadratic formula
     * (formula of roots of quadratic equation) (2*a).
     * @param a Coefficient of 'a' from a quadratic equation to be solved.
     * @return Value of denominator in quadratic formula.
     * @throws NumberFormatException is thrown if 0 is provided as coefficient 'a'
     *    because denominator cannot be zero.
     */

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

    /**
     * Calculate value of discriminant of quadratic equation (b*b-4*a*c)
     * @param a Coefficient 'a' from a quadratic equation to be solved.
     * @param b Coefficient 'b' from a quadratic equation to be solved.
     * @param c Coefficient 'c' from a quadratic equation to be solved.
     * @return The discriminant of quadratic equation if the three coefficients
     * of equation are provided.
     */


}
