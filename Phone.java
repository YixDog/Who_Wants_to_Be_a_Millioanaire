
public class Phone {
	private String  countrycode;
	private String  number;
	
	public Phone(String countrycode,String number){
		this.countrycode=countrycode;
		this.number=number;		
	}

	public String  getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String  countrycode) {
		this.countrycode = countrycode;
	}

	public String  getNumber() {
		return number;
	}

	public void setNumber(String  number) {
		this.number = number;
	}
	
	
}


