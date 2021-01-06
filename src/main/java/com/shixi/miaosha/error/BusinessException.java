package com.shixi.miaosha.error;



//包装器业务异常类实现   ---设计模式
//BusinessException和EmBusinessError都实现了CommonError的方法
//以至于外部不仅可以new一个对应EmBusinessError或者new一个对应的BusinessException
//都可以有errCode 和 errMsg对应的组装定义
//并且需要共同实现setErrMsg的方法可以将由原本EmBusinessError中定义的errMsg给覆盖掉

public class BusinessException extends Exception implements CommonError{

    //首先内部需要强关联一个对应的Error
    private CommonError commonError;

    //直接接受EmBusinessError的传参用于构造业务异常
    public BusinessException(CommonError commonError) {
        super();//需要加super，因为Exception会有自己的对应初始化机制
        this.commonError = commonError;
    }

    //接收自定义errMsg的方式构造业务异常
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }


    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
