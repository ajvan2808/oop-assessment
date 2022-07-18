package AbstractClass.MidTerm;

import java.util.Scanner;

public class Experience extends Employee {
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

	@Override
	public void input() throws Exception{
		System.out.println("Input employee's information");
		super.input();

		Scanner scanner = new Scanner(System.in);

		// Input years of exp
		System.out.println("Enter years of experience: ");
		do {
			try {
				setYearOfExp(scanner.nextInt());
				scanner.nextLine();
			} catch (Exception ex) {
				System.out.println("Try again: ");
				scanner.nextLine();
			}
		} while (this.YearOfExp == 0);


		// Input Professional skills
		System.out.println("Enter employee's professional skills: ");
		do {
			try {
				setProSkill(scanner.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				scanner.nextLine();
			}
		} while (this.ProSkill == null);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Employee: ");
		sb.append("\nID: ").append(this.getID());
		sb.append("\nFullname: ").append(this.getFullname());
		sb.append("\nBirthday: ").append(this.getBirthday());
		sb.append("\nPhone: ").append(this.getPhone());
		sb.append("\nEmail: ").append(this.getEmail());
		sb.append("\nEmployee type: ").append(this.getEmployee_type());
		sb.append("\nYears of experience: ").append(YearOfExp);
		sb.append("\nProfessional skills: ").append(ProSkill);
		
		return sb.toString();
	}
	
}
