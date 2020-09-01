package RecursivePolynomialStatements;

import problem1.EmptyQueueException;

public class BaseCasePolynomial implements IPolynomial {

  public BaseCasePolynomial() {
  }

  /**
   * A method addTerm, that takes a term (have a coefficient and a power), and adds the resulting
   * term to the polynomial
   *
   * @param coefficient adding coefficient to the polynomial
   * @param power       adding power to the polynomial
   */
  @Override
  public IPolynomial addTerm(Integer coefficient, Integer power) throws PolynomialException {
    if( coefficient == 0) {
      throw new PolynomialException("Coefficient can not be zero");
    }
    return new Polynomial(coefficient, power, this);
  }

  /**
   * A method removeTerm, that takes a power, and removes any and all terms in the polynomial with
   * that power.
   *
   * @param power - is the deleting power
   */
  @Override
  public IPolynomial removeTerm(Integer power) throws PolynomialException {
    throw new PolynomialException("This polynomial is empty");
  }

  /**
   * A method getDegree, that returns the degree of the polynomial
   *
   * @return - the degree of the polynomial
   */
  @Override
  public Integer getDegree() throws PolynomialException {
    throw new PolynomialException("This polynomial is empty");
  }

  /**
   * A method getCoefficient, that takes a power, and returns the coefficient for the term with that
   * power.
   *
   * @param power the power of coefficient
   * @return the coefficient for the power
   */
  @Override
  public Integer getCoefficient(Integer power) throws PolynomialException {
    throw new PolynomialException("This polynomial is empty");
  }

  /**
   * A method isSame, that takes another ConsPolynomial object and returns True if they are the
   * same, False otherwise.
   *
   * @param object - polynomial object to compare
   * @return - True if they are same and false otherwise
   */
  @Override
  public Boolean isSame(IPolynomial object) throws PolynomialException {
    return true;
  }

  /**
   * A method add, that takes another ConsPolynomial object, and returns the polynomial obtained by
   * adding the two polynomials.
   *
   * @param object - adding polynomial object
   * @return the polynomial obtained by adding two polynomial
   */
  @Override
  public IPolynomial add(IPolynomial object) throws PolynomialException {
    return object;
  }

  @Override
  public String toString() {
    return "";
  }
}
