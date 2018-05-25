package com.taotao.common.pojo;

/**
 * @author mengqa
 * @create 2018-05-25 11:26
 **/
public class PictureResult {

    private String url;

    private Integer error;

    private String message;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
