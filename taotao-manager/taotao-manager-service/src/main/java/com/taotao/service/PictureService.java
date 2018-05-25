package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mengqa
 * @create 2018-05-25 9:41
 **/
public interface PictureService {

    PictureResult uploadPicture(MultipartFile uploadFile);
}
