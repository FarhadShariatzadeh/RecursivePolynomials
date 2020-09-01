package RecursivePolynomialStatements;

import java.util.Objects;

public class Polynomial implements IPolynomial {

  private Integer power;
  private Integer coefficient;
  IPolynomial rest;

  public Polynomial(Integer coefficient, Integer power, IPolynomial rest) {
    this.power = power;
    this.coefficient = coefficient;
    this.rest = rest;
  }

  public Integer getPower() {
    return this.power;
  }

  public Integer getCoefficients() {
    return this.coefficient;
  }


  public IPolynomial getRest() {
    return this.rest;
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

    if (coefficient == 0) {
      throw new PolynomialException("Coefficient can't be zero");
    }

    if (power > this.power) {
      return new Polynomial(coefficient, power, this.rest);
    } else if (power == this.power) {
      this.coefficient = coefficient + this.coefficient;
      return this;
    } else {
      return new Polynomial(this.coefficient, this.power,
          this.rest.addTerm(coefficient, power));
    }
  }

  /**
   * A method removeTerm, that takes a power, and removes any and all terms in the polynomial with
   * that power.
   *
   * @param power - is the deleting power
   */
  @Override
  public IPolynomial removeTerm(Integer power) throws PolynomialException {
    if (power == this.power) {
      return this.rest;
    } else {
      return new Polynomial(this.coefficient, this.power, this.rest.removeTerm(power));
    }
  }

  /**
   * A method getDegree, that returns the degree of the polynomial
   *
   * @return - the degree of the polynomial
   */
  @Override
  public Integer getDegree() throws PolynomialException{
    return this.power;
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
    if (this.power == power) {
      return this.coefficient;
    } else {
      return this.rest.getCoefficient(power);
    }
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

      if (this.coefficient.equals(object.getCoefficient(object.getDegree())) &&
          this.power.equals(object.getDegree())) {
        return this.rest.isSame(object);
      }

    return false;
  }

  /**
   * A method add, that takes another ConsPolynomial object, and returns the polynomial obtained by
   * adding the two polynomials.
   *
   * @param object - adding polynomial object
   * @return the polynomial obtained by adding two polynomial
   */
  @Override
  public IPolynomial add(IPolynomial object) throws PolynomialException{
    if (object instanceof BaseCasePolynomial) {
      return this;
    }
    else {
      this.addTerm(object.getDegree(), object.getCoefficient(object.getDegree()));
      return this.add(object.removeTerm(object.getDegree()));
    }
  }

  /**
   * Helper method,
   * @param coefficient
   * @return
   */
  private String coefficientToString(Integer coefficient) {
    if (coefficient > 0) {
      return " + " + coefficient;
    }
    else  {
      return " " + coefficient;
    }
  }

  @Override
  public String toString() {

    if (power == 0) {
      return coefficientToString(coefficient);
    }
    else if (power == 1) {
      return coefficientToString(coefficient) + "x" +
          rest.toString();
    }
    else {
      return coefficientToString(coefficient) +
          "x^" + power +
          rest.toString();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Polynomial)) {
      return false;
    }
    Polynomial that = (Polynomial) o;
    return Objects.equals(getPower(), that.getPower()) &&
        Objects.equals(coefficient, that.coefficient) &&
        Objects.equals(getRest(), that.getRest());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPower(), coefficient, getRest());
  }
}