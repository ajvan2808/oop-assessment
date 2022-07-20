package AbstractClass.MidTerm;

import java.util.Scanner;

public class Intern extends Employee{
	private String Major;
	private String Semester;
	private String University;


	public String getMajor() {
		return Major;
	}
	public void setMajor(String major) throws Exception {
		if (major.isBlank()) {
			throw new Exception("Major of study cannot be blank");
		}
		this.Major = major;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		if (semester.isBlank()) {
			this.Semester = "N/A";
		}
		this.Semester = semester;
	}
	public String getUniversity() {
		return University;
	}
	public void setUniversity(String university) throws Exception{
		if (university.isBlank()) {
			throw new Exception("University cannot be blank");
		}
		this.University = university;
	}


	public Intern() {
		super();
	}
	public Intern(String fullname, String birthday, String phone, String email, String employee_type, String major,
			String semester, String university) throws Exception {
		super(fullname, birthday, phone, email, employee_type);
		Major = major;
		Semester = semester;
		University = university;
	}
	
	
	@Override
	public void input() throws Exception{
		System.out.println("----- Enter Intern information -----");
		super.input();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter major of study: ");
		do {
			try {
				setMajor(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.Major == null);

		System.out.println("Enter current semester: ");
		setSemester(sc.nextLine());

		System.out.println("Enter university: ");
		do {
			try {
				setUniversity(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.University == null);
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Intern ");
		sb.append("\nID: ").append(this.getID());
		sb.append("\nFullname: ").append(this.getFullname());
		sb.append("\nBirthday: ").append(this.getBirthday());
		sb.append("\nPhone: ").append(this.getPhone());
		sb.append("\nEmail: ").append(this.getEmail());
		sb.append("\nEmployee type: ").append(this.getEmployee_type());
		sb.append("\nMajor: ").append(Major);
		sb.append("\nCurrent semester: ").append(Semester);
		sb.append("\nUniversity: ").append(University);
		
		return sb.toString();
	}
}
