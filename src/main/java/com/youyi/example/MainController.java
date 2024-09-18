package com.youyi.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统检查使用，请勿删除
 * @author yoyocraft
 * @date 2024/09/17
 */
@RestController
public class MainController {

    @GetMapping("/check")
    public String check() {
        return "success";
    }


}
