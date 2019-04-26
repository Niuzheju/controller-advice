package com.niuzj.controlleradvice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author niuzj
 * @date 2019/4/26 14:58
 */
@Data
@NoArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -429942488081558386L;

    private int code;

    private String message;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
