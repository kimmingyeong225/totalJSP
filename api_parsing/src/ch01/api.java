package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class api {

	public static void main(String[] args) throws IOException {
		
		Gson gson = new Gson();
		
		
		
		// 객체 생성
		URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	
		conn.setRequestMethod("GET"); // 서버에게 자원 요청
		//받는 API에 따라 맞는 content-Type을 정해주면된다.
		conn.setRequestProperty("Content-type", "application/www-from-json");
		System.out.println("Respons code : " + conn.getResponseCode());
	
		BufferedReader rd;
		
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect(); // 서버 연결 끊기
//		System.out.println(sb.toString());
		apitest studentObject =  gson.fromJson(sb.toString(), apitest.class); // 객체 생성 --> new.. 대체 라고 생각해도..
		
		System.out.println(studentObject.getTitle());
	}
	
}
