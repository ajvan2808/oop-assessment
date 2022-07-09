package AbstractClass.MidTerm;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

abstract public class Employee {
	public static final int Experience = 0;
	public static final int Fresher = 1;
	public static final int Intern = 2;

	public static final String Experience_type = "Experience";
	public static final String Fresher_type = "Fresher";
	public static final String Intern_type = "Intern";

	private static final List<String> EmployeeType = List.of(Experience_type, Fresher_type, Intern_type); 


	private String ID;
	private String Fullname;
	private String Birthday;
	private String Phone;
	private String Email;
	private String Employee_type;
	private static int Employee_count=0;

	// Getter & Setter
	public String getID() {
		return ID;
	}
	
	public final void setID() throws Exception{
		UUID uuid = UUID.randomUUID();
		this.ID = uuid.toString();
	}

	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) throws Exception {
		if (fullname.isBlank()){
			throw new Exception("Please provide employee fullname!");
		}
		this.Fullname = fullname;
	}
	
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) throws Exception {
		if (birthday.isBlank()){
			throw new Exception("Please provide employee date of birth!");
		}
		this.Birthday = birthday;
	}
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) throws Exception {
		if (phone.isBlank()){
			throw new Exception("Please provide employee phone number!");
		}
		this.Phone = phone;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) throws Exception {
		if (email.isBlank()){
			throw new Exception("Please provide employee email!");
		}
		this.Email = email;
	}
	
	public String getEmployee_type() {
		return Employee_type;
	}

	public void setEmployee_type(String employee_type) throws Exception {
		if (employee_type.isBlank() || !EmployeeType.contains(employee_type)){
			throw new Exception("Please provide employee type!");
		}
		this.Employee_type = employee_type;
	}
	
	public static int getEmployeeCount(){
		return Employee_count;
	}

	// Constructor
	public Employee() {
		
	}

	public Employee(String fullname, String birthday, String phone, String email, String employee_type) throws Exception{
		setID();
		setFullname(fullname);
		setBirthday(birthday);
		setPhone(phone);
		setEmail(email);
		setEmployee_type(employee_type);
		Employee_count++;
	}


	// INNER CLASS
	public class Certificate {
		private String ID;
		private String CertificateName;
		private String CertificateRank;
		private String CertificateDate;

		public String getID(){
			return ID;
		}
		public final void setID(String id) throws Exception{
			if (id.isBlank()) {
				throw new Exception("Please enter education certificate ID!");
			}
			this.ID = id;
		}

		public String getCertificateName() {
			return CertificateName;
		}
		public void setCertificateName(String certificateName) throws Exception {
			if (certificateName.isBlank()) {
				throw new Exception("Please enter education certificate name!");
			}
			this.CertificateName = certificateName;
		}

		public String getCertificateRank() {
			return CertificateRank;
		}
		public void setCertificateRank(String certificateRank) throws Exception {
			if (certificateRank.isBlank()) {
				throw new Exception("Please enter education certificate rank!");
			}
			this.CertificateRank = certificateRank;
		}

		public String getCertificateDate() {
			return CertificateDate;
		}
		public void setCertificateDate(String certificateDate) throws Exception {
			if (certificateDate.isBlank()) {
				throw new Exception("Please enter education certificate issued date!");
			}
			this.CertificateDate = certificateDate;
		}

		public Certificate() {
		}

		public Certificate(String iD, String certificateName, String certificateRank, String certificateDate) throws Exception {
			setID(iD);
			setCertificateName(certificateName);
			setCertificateRank(certificateRank);
			setCertificateDate(certificateDate);
		}

		public void inputCert() {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter certificate ID: ");
			do {
				try {
					setID(sc.nextLine());
				} catch (Exception ex) {
					System.out.println("Try again: ");
					sc.nextLine();
				}
			} while (this.ID == null);

			System.out.println("Enter certificate Name: ");
			do {
				try {
					setCertificateName(sc.nextLine());
				} catch (Exception ex) {
					System.out.println("Try again: ");
					sc.nextLine();
				}
			} while (this.CertificateName == null);

			System.out.println("Enter certificate rank: ");
			do {
				try {
					setCertificateRank(sc.nextLine());
				} catch (Exception ex) {
					System.out.println("Try again: ");
					sc.nextLine();
				}
			} while (this.CertificateRank == null);

			System.out.println("Enter certificate issued date: ");
			do {
				try {
					setCertificateDate(sc.nextLine());
				} catch (Exception ex) {
					System.out.println("Try again: ");
					sc.nextLine();
				}
			} while (this.CertificateDate == null);
		}

		public void showCertificateInfo(){
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Certificate: { ");
			sb.append("ID: ").append(ID);
			sb.append(", Title: ").append(CertificateName);
			sb.append(", Rank: ").append(CertificateRank);
			sb.append(", Date: ").append(CertificateDate);
			return sb.toString();
		}

	}

	// ===== OUTTER CLASS METHODS ===== //

	public void input() throws Exception{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter '1' to generate employee ID: ");
		do {
			setID();
			System.out.println("New employee with ID are set: " + getID());
		} while (this.ID == null);

		System.out.println("Enter employee fullname: ");
		do {
			try {
				setFullname(sc.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.Fullname == null);


		System.out.println("Enter employee birthday: ");
		do {
			try {
				setBirthday(sc.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.Birthday == null);


		System.out.println("Enter employee phone number: ");
		do {
			try {
				setPhone(sc.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.Phone == null);


		System.out.println("Enter employee email: ");
		do {
			try {
				setEmail(sc.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.Email == null);


		System.out.println("Enter employee type [" + Experience_type
													+ Fresher_type
													+ Intern_type + "]:");
		do {
			try {
				setEmployee_type(sc.nextLine());
			} catch (Exception ex) {
				System.out.println("Try again: ");
				sc.nextLine();
			}
		} while (this.Employee_type == null);

	}


	public void showInfo(){
		System.out.println(this.toString());
	}

	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Employee: \n");
		sBuilder.append("ID: ").append(ID);
		sBuilder.append("\nFullname: ").append(Fullname);
		sBuilder.append("\nBirthday: ").append(Birthday);
		sBuilder.append("\nPhone: ").append(Phone);
		sBuilder.append("\nEmail: ").append(Email);
		sBuilder.append("\nEmployee type: ").append(Employee_type);

		return sBuilder.toString();
	}

	public void showCertificateInfo(){
		Certificate cert = new Certificate();
		cert.showCertificateInfo();
	}

}
