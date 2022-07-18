package AbstractClass.MidTerm;

import java.time.LocalDate;
import java.util.Scanner;

public class Fresher extends Employee{
	private String graduationDate;
	private String graduationRank;
	private String education;


	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) throws Exception {
		if (graduationDate.isBlank() || LocalDate.parse(graduationDate).isAfter(LocalDate.now())) {
			throw new Exception("Graduation date cannot be blank or after present");
		}
		this.graduationDate = graduationDate;
	}


	public String getGraduationRank() {
		return graduationRank;
	}
	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}


	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	
	public Fresher()
	{
		super();
	}

	public Fresher(String fullname, String birthday, String phone, String email, String employee_type,
			String graduationDate, String graduationRank, String education) throws Exception {
		super(fullname, birthday, phone, email, employee_type);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	@Override
	public void input() throws Exception {
		System.out.println("Input employees's information: ");
		super.input();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter graduation date in format yyyy-mm-dd: ");
		do {
			try {
				setGraduationDate(sc.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.graduationDate == null);

		System.out.println("Enter graduation rank: ");
		setGraduationRank(sc.nextLine());

		System.out.println("Enter level of education: ");
		
		


		
	}
}