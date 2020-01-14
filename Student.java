
public class Student implements Student_ {
	
	String fname , lname , hostel , department , cgpa;
	
	Student(String fname, String lname, String hostel , String department , String cgpa){
		this.fname = fname;
		this.lname = lname;
		this.cgpa = cgpa;
		this.hostel= hostel;
		this.department = department;
	}
	public String fname() {
		return fname;
	}

	public String lname() {
		return lname;
	}

	public String hostel() {
		return hostel ;
	}

	public String department() {
		return department;
	}

	public String cgpa() {
		return cgpa;
	}
	
	public String toString() {
		String l = fname + " "+ lname + " "+hostel + " "+ department +" "+ cgpa;
		return l;
	}

}
