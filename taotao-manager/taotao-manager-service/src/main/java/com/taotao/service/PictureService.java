package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传接口
 * @author wufenbin
 * 2017年7月19日
 */
public interface PictureService {

	Map uploadPicture(MultipartFile uploadFile );
}
