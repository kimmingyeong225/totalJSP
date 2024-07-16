package com.tenco.model;

import java.sql.Timestamp;

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
public class Board {

	private int id;
	private int userId;
	private String title;
	private String content;
	private Timestamp createdAt;
	
}
