package com.youyi.example.exception;

import com.youyi.example.enums.ReturnCodeEnum;
import lombok.Getter;

/**
 * @author yoyocraft
 * @date 2024/09/13
 */
@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ReturnCodeEnum returnCodeEnum;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ReturnCodeEnum returnCodeEnum) {
        this.returnCodeEnum = returnCodeEnum;
    }

    public BusinessException(String message, ReturnCodeEnum returnCodeEnum) {
        super(message);
        this.returnCodeEnum = returnCodeEnum;
    }
}
