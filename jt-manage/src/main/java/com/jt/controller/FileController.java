package com.jt.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;

@RestController
public class FileController {
	
	/**
	 * 文件上传成功之后,返回json数据
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/file")   
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException {
		//1.获取图片名称
		String fileName = fileImage.getOriginalFilename();
		
		//2.创建文件对象,指定上传目录
		File dir = new File("D:/1-jt-software/jt-images");
		if(!dir.exists()) {
			//如果文件不存在,创建目录
			dir.mkdirs();
		}
		
		String path = "D:/1-jt-software/jt-imagesfdg/"+fileName;
		File file = new File(path);
		
		//3.利用工具API执行输出操作
		fileImage.transferTo(file);
		return "文件上传成功!!!!!";
	}
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/pic/upload")
	public ImageVO fileUpload(MultipartFile uploadFile) {
		
		return fileService.upload(uploadFile);
	}
	
	
	
	
	
	
	
	
	
	
	
}
