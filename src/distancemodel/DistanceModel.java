/**
 */
package distancemodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distance Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link distancemodel.DistanceModel#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link distancemodel.DistanceModel#getThreshold <em>Threshold</em>}</li>
 * </ul>
 *
 * @see distancemodel.DistanceModelPackage#getDistanceModel()
 * @model
 * @generated
 */
public interface DistanceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Measurements</b></em>' containment reference list.
	 * The list contents are of type {@link distancemodel.Distance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurements</em>' containment reference list.
	 * @see distancemodel.DistanceModelPackage#getDistanceModel_Measurements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Distance> getMeasurements();

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(int)
	 * @see distancemodel.DistanceModelPackage#getDistanceModel_Threshold()
	 * @model
	 * @generated
	 */
	int getThreshold();

	/**
	 * Sets the value of the '{@link distancemodel.DistanceModel#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(int value);

} // DistanceModel
