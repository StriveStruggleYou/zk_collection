package org.ssy.zk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("zkStatus")
@Controller
public class ZkSatusController {

    @RequestMapping("/show")
    @ResponseBody
    public Object show() {
        return "show";
    }

}
