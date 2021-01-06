package com.shixi.miaosha.response;

public class CommonReturnType {
    //表明对应请求的返回处理结果  "success"或"fail"
    // 如果处理正常，必定返回success，如果服务器处理的   500是业务逻辑的错误
    private String status;

    //若status=success，则data内返回前端需要的json数据
    //若status=fail，则data内使用通用的错误码格式(自定义)
    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType creat(Object result) {
        return CommonReturnType.creat(result, "success");
    }

    public static CommonReturnType creat(Object result,String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }






    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
