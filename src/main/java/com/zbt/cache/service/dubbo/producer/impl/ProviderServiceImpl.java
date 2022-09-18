package com.zbt.cache.service.dubbo.producer.impl;

import com.zbt.cache.service.dubbo.producer.ProviderService;
import com.zbt.cache.service.dubbo.dto.DemoRequestDTO;
import com.zbt.cache.service.dubbo.dto.DemoResponseDTO;
import com.zbt.cache.service.dubbo.dto.UserDTO;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zoubaitao
 * date 2022/09/12
 */
@DubboService
public class ProviderServiceImpl implements ProviderService {

    @Override
    public DemoResponseDTO<UserDTO> getData(DemoRequestDTO requestDTO) {
        DemoResponseDTO<UserDTO> responseDTO = new DemoResponseDTO<>();
        responseDTO.setSuccess(Boolean.TRUE);
        responseDTO.setCode(NumberUtils.INTEGER_ZERO);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("henha");
        userDTO.setAge(18);
        userDTO.setAddress("The U.S.A");
        responseDTO.setData(userDTO);
        return responseDTO;
    }
}
