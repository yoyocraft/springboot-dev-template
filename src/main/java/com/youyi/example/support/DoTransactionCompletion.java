package com.youyi.example.support;

import lombok.AllArgsConstructor;
import org.springframework.transaction.support.TransactionSynchronization;

/**
 * 事务完成之后要执行的操作
 *
 * @author yoyocraft
 * @date 2024/09/13
 * @see org.springframework.transaction.support.TransactionSynchronization
 */
@AllArgsConstructor
public class DoTransactionCompletion implements TransactionSynchronization {

    private final Runnable actionAfterTransactionCompletion;

    @Override
    public void afterCompletion(int status) {
        if (status == TransactionSynchronization.STATUS_COMMITTED) {
            this.actionAfterTransactionCompletion.run();
        }
    }
}