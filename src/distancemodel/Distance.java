/**
 */
package distancemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link distancemodel.Distance#getLeft <em>Left</em>}</li>
 *   <li>{@link distancemodel.Distance#getRight <em>Right</em>}</li>
 *   <li>{@link distancemodel.Distance#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see distancemodel.DistanceModelPackage#getDistance()
 * @model
 * @generated
 */
public interface Distance extends EObject {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' attribute.
	 * @see #setLeft(String)
	 * @see distancemodel.DistanceModelPackage#getDistance_Left()
	 * @model
	 * @generated
	 */
	String getLeft();

	/**
	 * Sets the value of the '{@link distancemodel.Distance#getLeft <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' attribute.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(String value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' attribute.
	 * @see #setRight(String)
	 * @see distancemodel.DistanceModelPackage#getDistance_Right()
	 * @model
	 * @generated
	 */
	String getRight();

	/**
	 * Sets the value of the '{@link distancemodel.Distance#getRight <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' attribute.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see distancemodel.DistanceModelPackage#getDistance_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link distancemodel.Distance#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

} // Distance
