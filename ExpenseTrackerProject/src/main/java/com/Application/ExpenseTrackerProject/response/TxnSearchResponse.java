package com.Application.ExpenseTrackerProject.response;

import lombok.*;
import com.Application.ExpenseTrackerProject.model.User;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TxnSearchResponse {

    private User user;
    private Double expenditureAmount;
    private String expenseType;
    private String expenseDate;
}