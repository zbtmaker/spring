package com.zbt.cache.service.dubbo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zoubaitao
 * date 2022/09/12
 */
@Data
public class DemoResponseDTO<T> implements Serializable {

    private boolean success;

    private Integer code;

    private T data;
}
