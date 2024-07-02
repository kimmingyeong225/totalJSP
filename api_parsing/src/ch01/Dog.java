package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Dog {
	public static void main(String[] args) {
		

	Dog dog1 = new Dog();
	Dog dog2 = new Dog();
	
	Dog[] dogArr = {dog1, dog2};
	
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	String dogStr = gson.toJson(dog1);
	
	}
}
