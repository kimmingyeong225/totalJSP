package com.tenco.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TodoDTO {
	
	private int id;
	private int userId;
	private String title;
	private String descrption;
	private String dueDate;
	private String completed;
	
	// completed 를 데이터 변환 메서드를 만들어 보자
	public String completedToString() {
		System.out.println("completed : "+ completed);
		return this.completed.equals("1") ? "true" : "false" ;
	}

}
