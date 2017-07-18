package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传接口
 * @author Administrator
 *
 */
public interface PictureService {

	Map uploadPicture(MultipartFile uploadFile );
}
