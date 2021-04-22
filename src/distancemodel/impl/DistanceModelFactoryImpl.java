/**
 */
package distancemodel.impl;

import distancemodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DistanceModelFactoryImpl extends EFactoryImpl implements DistanceModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DistanceModelFactory init() {
		try {
			DistanceModelFactory theDistanceModelFactory = (DistanceModelFactory)EPackage.Registry.INSTANCE.getEFactory(DistanceModelPackage.eNS_URI);
			if (theDistanceModelFactory != null) {
				return theDistanceModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DistanceModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistanceModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DistanceModelPackage.DISTANCE_MODEL: return createDistanceModel();
			case DistanceModelPackage.DISTANCE: return createDistance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DistanceModel createDistanceModel() {
		DistanceModelImpl distanceModel = new DistanceModelImpl();
		return distanceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Distance createDistance() {
		DistanceImpl distance = new DistanceImpl();
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DistanceModelPackage getDistanceModelPackage() {
		return (DistanceModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DistanceModelPackage getPackage() {
		return DistanceModelPackage.eINSTANCE;
	}

} //DistanceModelFactoryImpl
