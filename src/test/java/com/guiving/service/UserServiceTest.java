package com.guiving.service;

import com.guiving.domain.user.User;
import com.guiving.domain.user.UserRepository;
import com.guiving.domain.vo.Name;
import com.guiving.domain.vo.PhoneNumber;
import com.guiving.domain.vo.enums.DeviceType;
import com.guiving.domain.vo.enums.JoinType;
import com.guiving.domain.vo.enums.Language;
import com.guiving.utils.CoreUtils;
import com.guiving.web.dto.user.UserResponseDto;
import com.guiving.web.dto.user.UserSaveRequestDto;
import com.guiving.web.dto.user.UserUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    List<User> list = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        list.forEach(
                x-> userRepository.deleteById(x.getId())
        );
    }

    @Test
    @Transactional
    public void save() throws Exception{
        UserSaveRequestDto dto = UserSaveRequestDto.builder()
                .email(CoreUtils.getRandomStr()+"@email.com")
                .firstName("firstName")
                .lastName("lastName")
                .joinType(JoinType.EMAIL.getKey())
                .language(Language.KOREAN.getKey())
                .phoneNumber("123123123")
                .deviceType(DeviceType.ANDROID.getKey())
                .password("password")
                .uid("uiduiduiduid")
                .nation("대한민국")
                .build();

        //System.out.println("toEntitytoEntity : " + dto.toEntity());
        Long id = userService.save(dto);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user가 존재하지 않습니다. id : " + id));

        System.out.println("element : " + user);
    }

    @Test
    public void checkDuplicatedEmail() {
    }

    @Test
    public void findById() {
        UserResponseDto dto = userService.findById(Long.parseLong("77"));
        System.out.println("element : " + dto);
    }

    @Test
    public void update() throws Exception{
        UserUpdateRequestDto dto = UserUpdateRequestDto.builder()
                .name(Name.builder().firstName("firstNAme").lastName("lastNAme").build())
                .phoneNumber(PhoneNumber.builder().phoneNumber("01010101010").build())
                .build();

        Long id = Long.parseLong("88");
        userService.update(id,dto);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user가 존재하지 않습니다. id : " + id));

        System.out.println("element : " + user);
    }
}