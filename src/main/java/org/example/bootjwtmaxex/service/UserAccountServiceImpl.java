package org.example.bootjwtmaxex.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.bootjwtmaxex.model.dto.UserAccountRequestDTO;
import org.example.bootjwtmaxex.model.entity.UserAccount;
import org.example.bootjwtmaxex.model.repository.UserAccountRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(UserAccountRequestDTO dto) throws BadRequestException {
        if(dto.username().isEmpty() || dto.password().isEmpty()) {
            throw new BadRequestException("빈 항목이 있습니다.");
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(dto.username());
        userAccount.setPassword(
        passwordEncoder.encode(dto.password())
        );
        try{
            userAccountRepository.save(userAccount);
        }catch(DataIntegrityViolationException ex){
            throw new BadRequestException("중복된 Username");
        }

    }
}
