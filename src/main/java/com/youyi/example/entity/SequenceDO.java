package com.youyi.example.entity;

import com.youyi.example.base.BaseDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yoyocraft
 * @date 2024/09/17
 */
@Getter
@Setter
@NoArgsConstructor
public class SequenceDO extends BaseDO {

    private Long seq;

    public SequenceDO(long seq) {
        this.seq = seq;
    }

}
