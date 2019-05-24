package com.aside.common;

public class CommonException extends RuntimeException{

    private static final long serialVersionUID = -7028310552858166951L;
    private String message;
    private int code;

    public CommonException(ResultCode code){
        super(code.message());
        this.message = code.message();
        this.code = code.value();
        this.printStackTrace();
    }

    public String getMessage(){
        return message;
    }

    public int getCode(){
        return code;
    }
}

