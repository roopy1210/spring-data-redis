package com.roopy.service;

import com.roopy.exception.UserExistException;
import com.roopy.exception.UserNotFoundException;
import com.roopy.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("UserService 테스트")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("사용자 등록")
    @Order(1)
    public void shouldRegisterUser() {
        User user = new User("roopy", "1234", "roopy@gmail.com");
        userService.save(user);

        User inquiryUser = userService.findUserByUserId(user.getUserId());
        Assertions.assertNotNull(inquiryUser, "사용자정보가 정상적으로 등록 되었습니다.");
    }
    
    @Test
    @DisplayName("사용자 조회") 
    @Order(2)
    public void shouldFindUser() {
        // 사용자ID에 해당하는 사용자 정보 조회
        User user = userService.findUserByUserId("roopy");
        
        // ID에 해당하는 사용자 정보 조회
        user =userService.findById(user.getId());
        Assertions.assertEquals("roopy", user.getUserId());
    }

    @Test
    @DisplayName("사용자 중복 등록 에러")
    @Order(3)
    public void isShouldThrowUserExistException() {
        Assertions.assertThrows(UserExistException.class,
                () -> userService.save(new User("roopy", "1234", "roopy@gmail.com")));
    }

    @Test
    @DisplayName("사용자 정보 수정 에러")
    @Order(4)
    public void isShouldUserNotFoundExceptionWhenModifyUser() {
        Assertions.assertThrows(UserNotFoundException.class,
                () -> userService.update(new User("roopy1", "1234", "roopy@gmail.com")));
    }

    @Test
    @DisplayName("사용자 수정")
    @Order(5)
    public void shouldModifyUser() {
        User user = userService.findUserByUserId("roopy");
        user.setEmail("martica@naver.com");

        user = userService.update(user);

        User inquiryUser = userService.findUserByUserId(user.getUserId());
        Assertions.assertEquals("martica@naver.com", inquiryUser.getEmail());
    }
    
    @Test
    @DisplayName("사용자 삭제")
    @Order(6)
    public void shouldRemove() {
        // 사용자ID에 해당하는 사용자 정보 조회
        User user = userService.findUserByUserId("roopy");

        userService.remove(user.getId());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> userService.findUserByUserId("roopy"));
    }
}
