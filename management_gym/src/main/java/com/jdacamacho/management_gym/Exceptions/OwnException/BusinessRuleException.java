package com.jdacamacho.management_gym.Exceptions.OwnException;

import com.jdacamacho.management_gym.Exceptions.ExceptionStructure.ErrorCode;

import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException{
    private final String messageKey;
    private String code;

    public BusinessRuleException(ErrorCode code){
        super(code.getCode());
        this.messageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public BusinessRuleException(final String message){
        super(message);
        this.messageKey = ErrorCode.BUSINESS_RULE_VIOLATION.getCode();
        this.code = ErrorCode.BUSINESS_RULE_VIOLATION.getCode();
    }
}
