
public class Person {
	
	private String name;
	private Date date;
	private Phone phone;
	private Address address;
	
	public Person(String name,Date date,Phone phone,Address address) {
		this.name=name;
		this.date=date;
		this.phone=phone;
		this.address=address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
