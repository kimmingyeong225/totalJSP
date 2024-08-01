package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/imageList")
public class imageListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public imageListController() {
        super();
    
    }


    // 주소설계
    // http://localhost:8080/imageList
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 이미지 파일이 저장된 경로를 가져 온다.
		String ulpoadDir = "C:\\work_web_kmk\\jsp_file_upload\\src\\main\\images";
		File dir = new File(ulpoadDir);
		
		// 디렉토리 내 파일 리스트를 가져 오는 방법
		File[] files = dir.listFiles();
		List<String> fileNames = new ArrayList<>();
		
		if(fileNames != null) {
			for(File f : files) {
				fileNames.add(f.getName());
			}
		}
		System.out.println("file length : " + fileNames.size());
		System.out.println("file names : " + fileNames.toString());
		
		request.setAttribute("fileNames", fileNames);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
