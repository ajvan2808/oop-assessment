package AbstractClass.MidTerm;

public class Experience extends Employee{
	private int YearOfExp;
	private String ProSkill;


	public int getYearOfExp() {
		return YearOfExp;
	}
	public void setYearOfExp(int yearOfExp) throws Exception {
		if (yearOfExp <= 0){
			throw new Exception("Please enter the employee's years of expereience!");
		}
		this.YearOfExp = yearOfExp;
	}

	
	public String getProSkill() {
		return ProSkill;
	}
	public void setProSkill(String proSkill) throws Exception {
		if (proSkill.isBlank()){
			throw new Exception("Professional skill cannot be blank!");
		}
		this.ProSkill = proSkill;
	}

	public Experience() {
		super();
	}

	public Experience(String fullname, String birthday, String phone, String email, String employee_type, int yearOfExp,
			String proSkill) throws Exception {
		super(fullname, birthday, phone, email, employee_type);
		this.YearOfExp = yearOfExp;
		this.ProSkill = proSkill;
	}


	
}
