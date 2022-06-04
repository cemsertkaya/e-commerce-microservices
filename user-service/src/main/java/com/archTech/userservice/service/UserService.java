package com.archTech.userservice.service;

import com.archTech.userservice.VO.Department;
import com.archTech.userservice.VO.ResponseTemplateVO;
import com.archTech.userservice.entity.User;
import com.archTech.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user)
    {
        log.info("Inside saveUser of userService");
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of userService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }


}
