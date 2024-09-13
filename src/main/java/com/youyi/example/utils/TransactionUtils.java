package com.youyi.example.utils;

import com.youyi.example.support.DoTransactionCompletion;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author yoyocraft
 * @date 2024/09/13
 */
public class TransactionUtils {

    /**
     * 在事务提交后执行 action
     * @param action 执行动作
     */
    public static void doAfterTransaction(Runnable action) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(new DoTransactionCompletion(action));
        }
    }
}
