package com.example.test.controller;

import com.example.test.feignInterface.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.List;

/**
 * Title:
 * Description:
 * Copyright:
 * Company:
 * Project: SrpingBootTest
 * Create User: TRS-chen
 * Create Time:2018/8/3 18:24
 */
@RestController
public class UserController {

    @Autowired
    private FeignInterface feignInterface;
    @Value("${aa}")
    private String enabled;

    /**
     * ribbon测试
     *
     * @param name
     * @return
     */
    @RequestMapping("/hello/{name}")
    public String test(@PathVariable String name) {
        return "Hi," + name;
    }

    /**
     * ribbon测试,传递jsonObject
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/getListData", method = RequestMethod.POST)
    public String getListData(@RequestParam MultiValueMap<String, Object> data) {
        List<?> jsonArray = null;
        if (null != data) {
            jsonArray = data.get("password");
        }
        return jsonArray.toString();
    }

    /**
     * feign测试
     *
     * @return
     */
    @RequestMapping(value = "/getStr", method = RequestMethod.GET)
    public String getStr() {
        String code = URLEncoder.encode("222111");
        String result = feignInterface.getStr(code);
        return result + enabled;
    }
}
