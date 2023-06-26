package com.oa.project.controller.hb;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oa.project.util.Constants;


@Controller
public class FileController {
	static Logger logger = Logger.getLogger(FileController.class);
	
	@RequestMapping("/upload/{name}")
	public void upload(@PathVariable("name") String name, HttpServletResponse response){
		response.setHeader("Content-Disposition", "attachment;filename="+name);
	}
	
	
	@RequestMapping("/show/{name}")
	public void show(@PathVariable("name") String name, HttpServletResponse response){
		try {
			File file = new File(Constants.IMAGE_PATH + name);
			if (file.exists()) {
				try {
					FileInputStream fis = new FileInputStream(file);
					OutputStream os = response.getOutputStream();
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = fis.read(b)) != -1) {
						os.write(b, 0, len);
					}
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
