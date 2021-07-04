package com.roopy.service;

import com.roopy.exception.UserExistException;
import com.roopy.exception.UserNotFoundException;
import com.roopy.model.User;

public interface UserService {

    /**
     * 사용자 등록
     * 
     * @param user 사용자정보
     * @return User 사용자정보
     */
    User save(User user) throws UserExistException;

    /**
     * 사용자정보 수정
     * 
     * @param user 사용자정보
     * @return User 사용자정보
     */
    User update(User user) throws UserNotFoundException;

    /**
     * 사용자 정보 조회
     * 
     * @param userId userId에 해당하는 사용자 정보 조회
     */
    User findUserByUserId(String userId) throws UserNotFoundException;

    /**
     * 사용자 정보 조회
     * 
     * @param id User 객체 Key
     * @return 사용자 정보
     * @throws UserNotFoundException 사용자 정보 존재하지 않은 경우 예외처리
     */
    User findById(Long id) throws UserNotFoundException;
    
    /**
     * 사용자 삭제
     * 
     * @param user 삭제대상 사용자정보
     */
    void remove(Long id);

}
