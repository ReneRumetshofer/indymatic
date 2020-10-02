package at.renerumetshofer.indymatic.entryPool;

/**
 * Acitivty entry for one Indy lesson.
 * 
 * @author ReneRumetshofer
 * @since 02.10.2020
 */
public class Activity {

	private String subject;
	private String activityDescription;
	
	/**
	 * Creates an Acitivity instance.
	 * 
	 * @param subject - Subject in which the activity takes place
	 * @param activityDescription - Description of the activity
	 */
	public Activity(String subject, String activityDescription) {
		this.subject = subject;
		this.activityDescription = activityDescription;
	}

	// GETTERS AND SETTERS
	
	public String getSubject() {
		return subject;
	}

	public String getActivityDescription() {
		return activityDescription;
	}	
	
	@Override
	public String toString() {
		return "Activity { subject = " + subject + ", activityDescription = " + activityDescription + "}";
	}
	
}
