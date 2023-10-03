package com.Application.ExpenseTrackerProject.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateExpenseTypeResponse {

    Integer userId;
    Integer expenseId;

}