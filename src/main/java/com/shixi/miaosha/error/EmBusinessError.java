package com.shixi.miaosha.error;

public enum EmBusinessError implements CommonError {

    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOWN_ERROR(10002, "未知错误"),
    //不要把异常抛给用户

    //需要接口改动ErrMsg


    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001, "用户不存在"),
    //在做分布式开发的时候，会遇到全局需要一个统一的状态码的流程，用户模块，商品模块，
    //信息怎么互通？错误信息需要标注全局错误，当系统越多，
    // 对应错误码的管理更需要在通用的文件里面进行管理


    ;

    //枚举本质上是面向对象的类
    private int errCode;
    private String errMsg;


    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    //定义的流程控制的机制，Exception
    //程序出现了任何抛不下去的异常，统一抛出Exception，这类Exception会被
    //最后的controller层的一个Springboot的handler捕获并去做一些处理
}
