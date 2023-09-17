package com.cspiration.mooc.exception;

public class ConditonException extends RuntimeException{
    private static final long seriaVersionUID = 1L;
    private String code;

    public ConditonException(String code,String name){
        super(name);
        this.code = code;
    }
    public ConditonException(String name){
        super(name);
        code = "500";
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
