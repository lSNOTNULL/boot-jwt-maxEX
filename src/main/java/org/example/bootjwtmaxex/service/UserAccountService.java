package org.example.bootjwtmaxex.service;

import org.apache.coyote.BadRequestException;
import org.example.bootjwtmaxex.model.dto.UserAccountJoinDTO;

public interface UserAccountService {
    void join(UserAccountJoinDTO dto) throws BadRequestException;


}
