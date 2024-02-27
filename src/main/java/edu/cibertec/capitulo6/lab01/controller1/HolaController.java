package edu.cibertec.capitulo6.lab01.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaController {

    @GetMapping("/ip")
    @ResponseBody
    public String json() {
        String ip = "{\"origin\": \"20.225.105.10\"}";
        return ip;
    }
}
