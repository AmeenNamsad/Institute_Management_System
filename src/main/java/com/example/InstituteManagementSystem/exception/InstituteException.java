package com.example.InstituteManagementSystem.exception;

public class InstituteException extends RuntimeException {

    private final String globalisationMessageCode;
    private final String defaultUserMessage;
    private final Object[] defaultUserMessageArgs;

    public InstituteException(String globalisationMessageCode, String defaultUserMessage,Object ...args) {
        super(defaultUserMessage);
        this.globalisationMessageCode = globalisationMessageCode;
        this.defaultUserMessage = defaultUserMessage;
        this.defaultUserMessageArgs = args;
    }
}
