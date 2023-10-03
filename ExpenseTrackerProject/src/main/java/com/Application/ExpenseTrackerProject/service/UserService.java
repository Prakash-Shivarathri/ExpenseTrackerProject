package com.Application.ExpenseTrackerProject.service;



import com.Application.ExpenseTrackerProject.model.User;
import com.Application.ExpenseTrackerProject.model.UserStatus;
import com.Application.ExpenseTrackerProject.repository.UserRepository;
import com.Application.ExpenseTrackerProject.request.CreateUserRequest;
import com.Application.ExpenseTrackerProject.response.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public CreateUserResponse addUser(CreateUserRequest createUserRequest) {
        User userFromDb = userRepository.findByEmailAddressJPQL(createUserRequest.getEmail());
        if(userFromDb == null){
            User user = createUserRequest.toUser();
            user.setUserStatus(UserStatus.ACTIVE);
            userFromDb = userRepository.save(user);
        }
        CreateUserResponse createUserResponse = CreateUserResponse.builder().userId(userFromDb.getId()).build();
        return createUserResponse;

    }
}