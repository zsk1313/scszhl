package org.zhl.scs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zhl.scs.domain.User;
import org.zhl.scs.domain.vo.UserVo;
import org.zhl.scs.util.PageModel;

import java.util.Map;

@RestController
//@RequestMapping("/test")
public class TestController {
    // 跳转到测试页面
    @PostMapping(value = "/test/page")
    public String page(@RequestParam() UserVo userVo) {
        System.out.println("test");
        System.out.println(userVo);
//        System.out.println(pageModel.getPageSize());
        return "user";
    }
}
class Vo{
    private UserVo userVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}
