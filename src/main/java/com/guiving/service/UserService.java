package com.guiving.service;

import com.guiving.domain.user.User;
import com.guiving.domain.user.UserRepository;
import com.guiving.web.dto.user.UserResponseDto;
import com.guiving.web.dto.user.UserSaveRequestDto;
import com.guiving.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto request){
        if(checkDuplicatedEmail(request.getEmail())) {
            throw new IllegalArgumentException(String.format("%s는 중복되는 Email입니다.", request.getEmail()));
        }
        return userRepository.save(request.toEntity()).getId();
    }

    public boolean checkDuplicatedEmail(String email){
        return userRepository.findAllByEmail(email).size() > 0;
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id){
        User user =  findUserById(id);
        return new UserResponseDto(user);
    }

    @Transactional
    public void update(Long id, UserUpdateRequestDto request){
        User user =  findUserById(id);
        user.updateInfo(request);
    }

    private User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user가 존재하지 않습니다. id : " + id));
    }


}
