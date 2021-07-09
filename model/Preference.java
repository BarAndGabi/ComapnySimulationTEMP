package application.model;

public class Preference {
	private PreferenceType pType;
	private int hoursChange;
	private final int REGULAR_START_HOUR = 8;
	private int currentStartHour;

	public Preference(PreferenceType pType, int hourChange) {
		this.hoursChange = hourChange;
		this.pType = pType;
		this.currentStartHour = this.REGULAR_START_HOUR;
		this.setStartHour();
	}

	public void setStartHour() {
		int changeTemp = this.hoursChange;
		switch (pType) {
		case EARLY_START:
			while (changeTemp > 0) {
				this.currentStartHour--;
				if (this.currentStartHour == -1)
					this.currentStartHour = 23;
				changeTemp--;
			}
			break;
		case LATE_START:
			while (changeTemp > 0) {
				this.currentStartHour++;
				if (this.currentStartHour == 24)
					this.currentStartHour = 0;
				changeTemp--;
			}
			break;

		}

	}

	public int getStartHour() {
		return this.currentStartHour;
	}

}
