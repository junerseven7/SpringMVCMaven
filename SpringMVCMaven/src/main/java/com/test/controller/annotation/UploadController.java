package com.test.controller.annotation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UploadController {

	@RequestMapping("/upload/file")
	public String fileupload(@RequestParam("aaa") CommonsMultipartFile file, HttpServletRequest res) {

		System.out.println("File Name ===============" + file.getOriginalFilename());
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream("D:\\" + file.getOriginalFilename() + "_" + new Date().getTime());
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.flush();
				fos.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
	
	@RequestMapping("/upload/fileImprove")
	public String improveFileUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			
			Iterator it  = multiRequest.getFileNames();
			while (it.hasNext()) {
				MultipartFile file  = multiRequest.getFile((String)it.next());
				
				if(file != null ){
					String fileName = "demoUpload" + file.getOriginalFilename();
					String path = "D:\\" + fileName;
					File local = new File(path);
					file.transferTo(local);
				}
			}
		}
		return "success";
	}
}
