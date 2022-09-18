package com.zbt.cache.service.dubbo.producer;

import com.zbt.cache.service.dubbo.dto.DemoRequestDTO;
import com.zbt.cache.service.dubbo.dto.DemoResponseDTO;
import com.zbt.cache.service.dubbo.dto.UserDTO;

/**
 * @author zoubaitao
 * date 2022/09/12
 */
public interface ProviderService {

    DemoResponseDTO<UserDTO> getData(DemoRequestDTO requestDTO);
}
