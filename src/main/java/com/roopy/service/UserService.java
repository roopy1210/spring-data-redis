package com.roopy.service;

import com.roopy.model.User;

public interface UserService {

    /**
     * 사용자 추가/수정
     * 
     * @param user 사용자정보
     * @return User 사용자정보
     */
    User save(User user);

    /**
     * 사용자 정보 조회
     * 
     * @param userId userId에 해당하는 사용자 정보 조회
     */
    User findUserByUserId(String userId);

    /**
     * 사용자 삭제
     * 
     * @param user 삭제대상 사용자정보
     */
    void remove(User user);

}
