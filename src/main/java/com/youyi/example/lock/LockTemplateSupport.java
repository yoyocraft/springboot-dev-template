package com.youyi.example.lock;

import com.youyi.example.enums.ReturnCodeEnum;
import com.youyi.example.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yoyocraft
 * @date 2024/09/13
 */
@Component
@RequiredArgsConstructor
public class LockTemplateSupport {

    private final DistributedLock distributedLock;

    public void lock(String key, int expire, TimeUnit timeUnit, Runnable action) {
        Boolean locked = distributedLock.lock(key, expire, timeUnit);
        if (!locked) {
            throw new BusinessException(ReturnCodeEnum.REQUEST_LATER);
        }

        try {
            action.run();
        } finally {
            distributedLock.unlock(key);
        }
    }


}
