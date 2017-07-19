package com.taotao.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	/**
	 * 通过spring容器   从配置文件中取值  
	 */
	@Value("{FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("{FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("{FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("{FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("{IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	@Override
	public Map uploadPicture(MultipartFile uploadFile) {

		Map<Object, Object> resultMap = new HashMap<>();
		
		//生成一个新的文件名
		//去除原文件名
		String oldName = uploadFile.getOriginalFilename();
		//生成新的文件名
		String newName = IDUtils.genImageName();
		newName = newName+oldName.substring(oldName.lastIndexOf("."));
		//图片上传
		try {
			boolean result =  FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH,new DateTime().toString("/yyyy/MM/dd"), newName, uploadFile.getInputStream());
			if(!result){
				resultMap.put("error",1);
				resultMap.put("message", "错误信息");
				return resultMap;
			}
			resultMap.put("error",0);
			resultMap.put("url", IMAGE_BASE_URL+new DateTime().toString("/yyyy/MM/dd")+"/"+newName);
			return resultMap;
		} catch (IOException e) {
			resultMap.put("error",1);
			resultMap.put("message", "添加图片发生异常");
			return resultMap;
		}

	}

}
