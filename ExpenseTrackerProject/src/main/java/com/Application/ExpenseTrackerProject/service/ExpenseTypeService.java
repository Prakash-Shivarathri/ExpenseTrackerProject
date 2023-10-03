package com.Application.ExpenseTrackerProject.service;

package org.gfg.expenseTracker.service;

import com.Application.ExpenseTrackerProject.model.ExpenseTypes;
import com.Application.ExpenseTrackerProject.model.User;
import com.Application.ExpenseTrackerProject.model.UserStatus;
import com.Application.ExpenseTrackerProject.repository.ExpenseTypeRepository;
import com.Application.ExpenseTrackerProject.repository.UserRepository;
import com.Application.ExpenseTrackerProject.request.CreateExpenseTypeRequest;
import com.Application.ExpenseTrackerProject.response.CreateExpenseTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class f
        ExpenseTypeService {

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    private UserRepository userRepository;

    public CreateExpenseTypeResponse addExpenseType(CreateExpenseTypeRequest expenseTypeRequest) {
        ExpenseTypes expenseTypesFromDB  = expenseTypeRepository.findByExpenseType(expenseTypeRequest.getExpenseType());
        if(expenseTypesFromDB == null){
            ExpenseTypes expenseTypes = expenseTypeRequest.toExpenseTypes();
            expenseTypesFromDB = expenseTypeRepository.save(expenseTypes);
        }
        // handle ->  user is not present -> say -> then we will create an entry
        User userFromDB = userRepository.findByEmail(expenseTypesFromDB.getCreatedBy());
        if(userFromDB == null){
            User user = User.builder().
                    email(expenseTypeRequest.getUserEmail()).
                    userStatus(UserStatus.ACTIVE).
                    build();
            userFromDB = userRepository.save(user);
        }

        CreateExpenseTypeResponse createExpenseTypeResponse = CreateExpenseTypeResponse.builder().
                expenseId(expenseTypesFromDB.getId()).
                userId(userFromDB.getId()).
                build();

        return createExpenseTypeResponse;
    }


}
// cost >= 200 filter
// expenseDate yes filter
// notes -> yes filter
// expensetype
// 1 option i should create different method for all