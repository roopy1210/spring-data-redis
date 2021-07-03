package com.roopy.service;

import com.roopy.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("UserService 테스트")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("사용자 등록")
    @Order(1)
    public void shouldAdd() {
        User user = new User("roopy", "1234", "roopy@gmail.com");
        userService.save(user);

        User inquiryUser = userService.findUserByUserId(user.getUserId());
        Assertions.assertNotNull(inquiryUser, "사용자정보가 정상적으로 등록 되었습니다.");
    }

    @Test
    @DisplayName("사용자 수정")
    @Order(2)
    public void shouldModify() {
        User user = userService.findUserByUserId("roopy");
        user.setEmail("martica@naver.com");

        userService.save(user);

        User inquiryUser = userService.findUserByUserId(user.getUserId());
        Assertions.assertEquals("martica@naver.com", inquiryUser.getEmail());
    }
    
    @Test
    @DisplayName("사용자 삭제")
    @Order(3)
    public void shouldRemove() {
        User user = userService.findUserByUserId("roopy");
        userService.remove(user);

        User inquiryUser = userService.findUserByUserId(user.getUserId());
        Assertions.assertNull(inquiryUser);
    }

}
