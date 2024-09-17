package com.youyi.example.service;

import com.youyi.example.dao.SequenceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yoyocraft
 * @date 2024/09/17
 */
@Service
public class SequenceService {
    @Autowired
    private SequenceDAO sequenceDAO;

}
