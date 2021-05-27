package aufgabe02;

public class Student {
	private int int_matrikelNR;
	private String str_name;

	public Student(int num, String name) {
		int_matrikelNR = num;
		str_name = name;
	}

	public int getInt_matrikelNR() {
		return int_matrikelNR;
	}

	public void setInt_matrikelNR(int int_matrikelNR) {
		this.int_matrikelNR = int_matrikelNR;
	}

	public String getStr_name() {
		return str_name;
	}

	public void setStr_name(String str_name) {
		this.str_name = str_name;
	}

}
