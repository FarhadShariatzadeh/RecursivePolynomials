package RecursivePolynomialStatements;

public interface IPolynomial {

  /**
   * A method addTerm, that takes a term (have a coefficient and a power), and
   * adds the resulting term to the polynomial
   * @param coefficient adding coefficient to the polynomial
   * @param power adding power to the polynomial
   * @return new IPolynomial with the new term
   * @throws PolynomialException an exception when the coefficient is zero
   */
  IPolynomial addTerm(Integer coefficient, Integer power) throws PolynomialException;

  /**
   * A method removeTerm, that takes a power, and removes any and all terms in the
   * polynomial with that power.
   * @param power - is the deleting power
   * @return new IPolynomial with the remove term
   * @throws PolynomialException an exception when the the Polynomial is empty
   */
  IPolynomial removeTerm(Integer power) throws PolynomialException;

  /**
   * A method getDegree, that returns the degree of the polynomial
   * @return - the degree of the polynomial
   * @throws PolynomialException an exception when the the Polynomial is empty
   */
  Integer getDegree() throws PolynomialException;

  /**
   * A method getCoefficient, that takes a power, and returns the coefficient for the
   * term with that power.
   * @param power the power of coefficient
   * @return the coefficient for the power
   * @throws PolynomialException an exception when the the Polynomial is empty
   */
  Integer getCoefficient(Integer power) throws PolynomialException;

  /**
   * A method isSame, that takes another ConsPolynomial object and returns True if they
   * are the same, False otherwise.
   * @param object - polynomial object to compare
   * @return - True if they are same and false otherwise
   */
  Boolean isSame(IPolynomial object) throws PolynomialException;

  /**
   * A method add, that takes another ConsPolynomial object, and returns the polynomial
   * obtained by adding the two polynomials.
   * @param object - adding polynomial object
   * @return the polynomial obtained by adding two polynomial
   * @throws PolynomialException an exception when the the Polynomial is empty
   */
  IPolynomial add(IPolynomial object) throws PolynomialException;

}
