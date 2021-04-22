/**
 */
package distancemodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see distancemodel.DistanceModelFactory
 * @model kind="package"
 * @generated
 */
public interface DistanceModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "distancemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs.gssi.it/distancemodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "distance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DistanceModelPackage eINSTANCE = distancemodel.impl.DistanceModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link distancemodel.impl.DistanceModelImpl <em>Distance Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see distancemodel.impl.DistanceModelImpl
	 * @see distancemodel.impl.DistanceModelPackageImpl#getDistanceModel()
	 * @generated
	 */
	int DISTANCE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Measurements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_MODEL__MEASUREMENTS = 0;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_MODEL__THRESHOLD = 1;

	/**
	 * The number of structural features of the '<em>Distance Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Distance Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link distancemodel.impl.DistanceImpl <em>Distance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see distancemodel.impl.DistanceImpl
	 * @see distancemodel.impl.DistanceModelPackageImpl#getDistance()
	 * @generated
	 */
	int DISTANCE = 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE__LEFT = 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE__RIGHT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Distance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Distance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link distancemodel.DistanceModel <em>Distance Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distance Model</em>'.
	 * @see distancemodel.DistanceModel
	 * @generated
	 */
	EClass getDistanceModel();

	/**
	 * Returns the meta object for the containment reference list '{@link distancemodel.DistanceModel#getMeasurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurements</em>'.
	 * @see distancemodel.DistanceModel#getMeasurements()
	 * @see #getDistanceModel()
	 * @generated
	 */
	EReference getDistanceModel_Measurements();

	/**
	 * Returns the meta object for the attribute '{@link distancemodel.DistanceModel#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see distancemodel.DistanceModel#getThreshold()
	 * @see #getDistanceModel()
	 * @generated
	 */
	EAttribute getDistanceModel_Threshold();

	/**
	 * Returns the meta object for class '{@link distancemodel.Distance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distance</em>'.
	 * @see distancemodel.Distance
	 * @generated
	 */
	EClass getDistance();

	/**
	 * Returns the meta object for the attribute '{@link distancemodel.Distance#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left</em>'.
	 * @see distancemodel.Distance#getLeft()
	 * @see #getDistance()
	 * @generated
	 */
	EAttribute getDistance_Left();

	/**
	 * Returns the meta object for the attribute '{@link distancemodel.Distance#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right</em>'.
	 * @see distancemodel.Distance#getRight()
	 * @see #getDistance()
	 * @generated
	 */
	EAttribute getDistance_Right();

	/**
	 * Returns the meta object for the attribute '{@link distancemodel.Distance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see distancemodel.Distance#getValue()
	 * @see #getDistance()
	 * @generated
	 */
	EAttribute getDistance_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DistanceModelFactory getDistanceModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link distancemodel.impl.DistanceModelImpl <em>Distance Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see distancemodel.impl.DistanceModelImpl
		 * @see distancemodel.impl.DistanceModelPackageImpl#getDistanceModel()
		 * @generated
		 */
		EClass DISTANCE_MODEL = eINSTANCE.getDistanceModel();

		/**
		 * The meta object literal for the '<em><b>Measurements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTANCE_MODEL__MEASUREMENTS = eINSTANCE.getDistanceModel_Measurements();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTANCE_MODEL__THRESHOLD = eINSTANCE.getDistanceModel_Threshold();

		/**
		 * The meta object literal for the '{@link distancemodel.impl.DistanceImpl <em>Distance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see distancemodel.impl.DistanceImpl
		 * @see distancemodel.impl.DistanceModelPackageImpl#getDistance()
		 * @generated
		 */
		EClass DISTANCE = eINSTANCE.getDistance();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTANCE__LEFT = eINSTANCE.getDistance_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTANCE__RIGHT = eINSTANCE.getDistance_Right();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTANCE__VALUE = eINSTANCE.getDistance_Value();

	}

} //DistanceModelPackage
