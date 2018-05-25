package com.taotao.service.impl;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author mengqa
 * @create 2018-05-25 9:42
 **/
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_HOST}")
    private String FTP_HOST;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public PictureResult uploadPicture(MultipartFile uploadFile) {
        PictureResult pictureResult = new PictureResult();
        try {
            String oldName = uploadFile.getOriginalFilename();
            String newName = IDUtils.genImageName();
            newName += oldName.substring(oldName.lastIndexOf("."));
            String imagePath = new DateTime
                    ().toString("yyyy/MM/dd");
            boolean result = FtpUtil.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
            if (!result) {
                pictureResult.setError(1);
                pictureResult.setMessage("文件上传失败");
                return pictureResult;
            }
            pictureResult.setError(0);
            pictureResult.setUrl(IMAGE_BASE_URL + "/" + imagePath + "/" + newName);
        } catch (IOException e) {
            pictureResult.setError(1);
            pictureResult.setMessage("文件上传异常");
            e.printStackTrace();
            return pictureResult;
        }
        return pictureResult;
    }
}
