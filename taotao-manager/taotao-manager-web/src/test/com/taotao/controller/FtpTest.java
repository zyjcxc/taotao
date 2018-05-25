package com.taotao.controller;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author mengqa
 * @create 2018-05-24 17:00
 **/
public class FtpTest {

    @Test
    public void testFtpClient() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.1.133", 21);
        ftpClient.login("ftpuser", "ftpuser");
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\test.jpg"));
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.storeFile("mqa.jpg", inputStream);
        ftpClient.logout();
    }

    @Test
    public void testFtpUtil() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\test.jpg"));
        FtpUtil.uploadFile("192.168.1.133", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "2018/03/01", "mqa.jpg",  inputStream);
    }
}
