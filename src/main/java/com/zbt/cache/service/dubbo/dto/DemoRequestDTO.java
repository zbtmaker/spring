package com.zbt.cache.service.dubbo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zoubaitao
 * date 2022/09/12
 */
@Data
public class DemoRequestDTO implements Serializable {

    private Integer id;

    private String name;
}
