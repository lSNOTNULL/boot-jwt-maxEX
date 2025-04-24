package org.example.bootjwtmaxex.service;

import org.apache.coyote.BadRequestException;
import org.example.bootjwtmaxex.model.dto.UserAccountRequestDTO;

public interface UserAccountService {
    void join(UserAccountRequestDTO dto) throws BadRequestException;


}
