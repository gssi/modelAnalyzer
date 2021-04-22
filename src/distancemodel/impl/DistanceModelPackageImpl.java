/**
 */
package distancemodel.impl;

import distancemodel.Distance;
import distancemodel.DistanceModel;
import distancemodel.DistanceModelFactory;
import distancemodel.DistanceModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DistanceModelPackageImpl extends EPackageImpl implements DistanceModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distanceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distanceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see distancemodel.DistanceModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DistanceModelPackageImpl() {
		super(eNS_URI, DistanceModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DistanceModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DistanceModelPackage init() {
		if (isInited) return (DistanceModelPackage)EPackage.Registry.INSTANCE.getEPackage(DistanceModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDistanceModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DistanceModelPackageImpl theDistanceModelPackage = registeredDistanceModelPackage instanceof DistanceModelPackageImpl ? (DistanceModelPackageImpl)registeredDistanceModelPackage : new DistanceModelPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theDistanceModelPackage.createPackageContents();

		// Initialize created meta-data
		theDistanceModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDistanceModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DistanceModelPackage.eNS_URI, theDistanceModelPackage);
		return theDistanceModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDistanceModel() {
		return distanceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDistanceModel_Measurements() {
		return (EReference)distanceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDistanceModel_Threshold() {
		return (EAttribute)distanceModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDistance() {
		return distanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDistance_Left() {
		return (EAttribute)distanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDistance_Right() {
		return (EAttribute)distanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDistance_Value() {
		return (EAttribute)distanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DistanceModelFactory getDistanceModelFactory() {
		return (DistanceModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		distanceModelEClass = createEClass(DISTANCE_MODEL);
		createEReference(distanceModelEClass, DISTANCE_MODEL__MEASUREMENTS);
		createEAttribute(distanceModelEClass, DISTANCE_MODEL__THRESHOLD);

		distanceEClass = createEClass(DISTANCE);
		createEAttribute(distanceEClass, DISTANCE__LEFT);
		createEAttribute(distanceEClass, DISTANCE__RIGHT);
		createEAttribute(distanceEClass, DISTANCE__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(distanceModelEClass, DistanceModel.class, "DistanceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDistanceModel_Measurements(), this.getDistance(), null, "measurements", null, 0, -1, DistanceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDistanceModel_Threshold(), ecorePackage.getEInt(), "threshold", null, 0, 1, DistanceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(distanceEClass, Distance.class, "Distance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDistance_Left(), ecorePackage.getEString(), "left", null, 0, 1, Distance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDistance_Right(), ecorePackage.getEString(), "right", null, 0, 1, Distance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDistance_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, Distance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DistanceModelPackageImpl
