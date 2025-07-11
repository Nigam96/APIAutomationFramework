package com.api.models.request;

public class PatchProfileRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String address;

	
	public PatchProfileRequest(String firstName, String lastName, String email, String mobileNumber,String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address=address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "PatchProfileRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}



	public static class Builder {
		private String firstName;
		private String lastName;
		private String email;
		private String mobileNumber;
		private String address;
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public PatchProfileRequest build() {
			PatchProfileRequest patchProfileRequest = new PatchProfileRequest(firstName, lastName, email, mobileNumber,address);
			return patchProfileRequest;
		}
	}
}
