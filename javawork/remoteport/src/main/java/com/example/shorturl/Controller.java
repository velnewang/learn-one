package com.example.shorturl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/*")
    public Map<String, String> port(HttpServletRequest req) {
        Enumeration<String> hNames = req.getHeaderNames();
        List<String> hList = new ArrayList<>();
        while (hNames.hasMoreElements()) {
            hList.add(hNames.nextElement());
        }
        Map<String, String> hMap = new LinkedHashMap<>();
        hMap.put("getRemoteAddr", "" + req.getRemoteAddr());
        hMap.put("getRemoteHost", "" + req.getRemoteHost());
        hMap.put("getRemoteUser", "" + req.getRemoteUser());
        hMap.put("getRemotePort", "" + req.getRemotePort());
        hList.forEach(hName -> hMap.put(hName, req.getHeader(hName)));

        return hMap;
    }

}
