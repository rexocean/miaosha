package com.shixi.miaosha.error;

public interface CommonError {

    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);

    //把error信息取出来
}
