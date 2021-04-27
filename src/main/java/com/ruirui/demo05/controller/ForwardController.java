package com.ruirui.demo05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ForwardController {
    @GetMapping("/{folder}/{file}/index")
    public String index(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return folder+"/"+file;
    }
}
