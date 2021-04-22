/**
 */
package distancemodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see distancemodel.DistanceModelPackage
 * @generated
 */
public interface DistanceModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DistanceModelFactory eINSTANCE = distancemodel.impl.DistanceModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Distance Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distance Model</em>'.
	 * @generated
	 */
	DistanceModel createDistanceModel();

	/**
	 * Returns a new object of class '<em>Distance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distance</em>'.
	 * @generated
	 */
	Distance createDistance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DistanceModelPackage getDistanceModelPackage();

} //DistanceModelFactory
