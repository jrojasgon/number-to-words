package com.jrojas.sonatype.controller;


/**
 * The object that represents the Result response
 */
public class ResultResponse {

    private final String result;
    private boolean hasError;

    /**
     * @param result the result to set
     */
    public ResultResponse(String result) {
        this.result = result;
    }

    /**
     * @param result the result to set
     * @param hasError the flag for error to set
     */
    public ResultResponse(String result, boolean hasError) {
        this.result = result;
        this.hasError = hasError;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }


    /**
     * @return a flag to indicate if there is an error
     */
    public boolean isHasError() {
        return hasError;
    }
}

