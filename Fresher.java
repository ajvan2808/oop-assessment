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
	public void setEducation(String education) throws Exception {
		if (education.isBlank()) {
			throw new Exception("Education cannot be blank");
		}
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
		do {
			try {
				setEducation(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.education == null);
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
		sb.append("\nGraduation date: ").append(graduationDate);
		sb.append("\nGraduation rank: ").append(graduationRank);
		sb.append("\nEducation: ").append(education);
		
		return sb.toString();
	}
}