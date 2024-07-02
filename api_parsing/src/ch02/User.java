package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {
	
	private int id;
	private String name;
	private String username;
	private String email;
	
	private Address address;
	
	private Geo geo;
	
	private String phone;
	private String website;
	
	private Company company;

}
