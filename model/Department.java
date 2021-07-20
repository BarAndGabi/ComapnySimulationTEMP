package application.model;

import java.util.ArrayList;

public class Department implements syncAble, choosePreference {
	private ArrayList<Role> roles;
	private boolean sync;
	private String name;
	private boolean changePreference;
	private Preference preference;
	protected double currentMoneyProfitForDay;
	protected double currentHourProfitForDay;

	public Department(String name, boolean sync, PreferenceType p, int hourChange, boolean changePreference) {
		this.sync = sync;
		this.roles = new ArrayList<Role>();
		this.name = name;
		this.preference = new Preference(p, hourChange);
		this.changePreference = changePreference;
		this.currentHourProfitForDay = 0;
		this.currentMoneyProfitForDay = 0;
	}

	@Override
	public void choosePreference(PreferenceType t, int change) throws Exception {
		if (changePreference)
			this.preference = new Preference(t, change);
		else
			throw new cantChangePreferenceException();
	}

	public void addEmployee(Employee a) {
		int index = this.findRole(a.getRole());
		this.roles.get(index).addEmployee(a);

	}

	private int findRole(Role r) {
		return this.roles.indexOf(r);
	}

	public void addRole(Role r) throws Exception {
		int index = findRole(r);
		if (index == -1)
			this.roles.add(r);
		else
			throw new alreadyExistException();
	}

	@Override
	public boolean isSynced() {
		return this.sync;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Department))
			return false;
		Department temp = (Department) obj;
		if (temp.getName() == this.name)
			return true;
		else
			return false;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean canChoosePreference() {
		return this.changePreference;
	}

	public void calcProfit() {
		if (this.changePreference)
			if (this.sync)
				this.calcProfitWithPreference();
			else
				this.calcProfitNoPreference();
		else
			this.calcProfitNoPreference();
	}

	private void calcProfitWithPreference() {
		// TODO Auto-generated method stub

	}

	private void calcProfitNoPreference() {
		for (int i = 0; i < this.roles.size(); i++) {

		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer(this.getClass().getSimpleName() + " " + this.name + " info:" + "\n"
				+ "\nsyncronized department ? : " + this.sync + "\ncan choose preference?  : " + this.changePreference
				+ "\n preference : " + this.preference.toString() + "\nday's hours in value: "
				+ this.currentHourProfitForDay + "\nday's hours in money value: " + this.currentMoneyProfitForDay);
		str.append("\nthe employees in this role are: \n");
		for (int i = 0; i < this.roles.size(); i++) {
			str.append("     " + (i + 1) + ") " + this.roles.get(i).toString() + "\n");
		}

		return str.toString();

	}
}
