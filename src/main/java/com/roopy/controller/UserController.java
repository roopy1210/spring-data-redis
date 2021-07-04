package com.roopy.controller;

import com.roopy.exception.UserExistException;
import com.roopy.exception.UserNotFoundException;
import com.roopy.model.User;
import com.roopy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 사용자 등록
     * 
     * @param user 등록 사용자 정보
     * @return ResponseEntity<User> 등록 사용자 정보
     * @throws UserExistException 사용자 중복 등록시 예외 처리
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws UserExistException {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    /**
     * 사용자 수정
     *
     * @param user 수정 사용자 정보
     * @return ResponseEntity<User> 수정 사용자 정보
     * @throws UserNotFoundException 사용자 정보가 존재하지 않은 경우 예외 처리
     */
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    /**
     * 사용자 조회
     *
     * @param userId 사용자ID
     * @return ResponseEntity<User> 사용자 정보
     * @throws UserNotFoundException 사용자 정보가 존재하지 않은 경우 예외 처리
     */
    @PostMapping("/{userId}")
    public ResponseEntity<User> findUser(@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.findUserByUserId(userId), HttpStatus.OK);
    }

    /**
     * 사용자 삭제
     *
     * @param id User 객체 Key
     * @return ResponseEntity<String> 삭제 처리 메세지
     * @throws UserNotFoundException 사용자 정보가 존재하지 않은 경우 예외 처리
     */
    @PostMapping("/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable String id) throws UserNotFoundException {
        userService.remove(Long.parseLong(id));

        return new ResponseEntity<>("사용자 정보가 정상적으로 삭제 되었습니다.", HttpStatus.OK);
    }
}
