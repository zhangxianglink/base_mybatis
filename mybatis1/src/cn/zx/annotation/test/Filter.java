package cn.zx.annotation.test;

@Table("user")
public class Filter {

	@Column("id")
	private Integer id;
	@Column("name")
	private String name;
	@Column("nickname")
	private String nickname;
	@Column("address")
	private String address;
	@Column("phoneNumber")
	private Integer phoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", name=" + name + ", nickname=" + nickname + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
