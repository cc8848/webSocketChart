package com.websocket.controller;

import com.websocket.handler.MyWebSocketHander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    static Logger logger = LoggerFactory.getLogger(AdminController.class);

//    @Autowired(required = false)
//    private AdminService adminService;

    @Bean
    public MyWebSocketHander systemWebSocketHandler() {
        return new MyWebSocketHander();
    }


    @RequestMapping("/auditing")
    @ResponseBody
    public String auditing(HttpServletRequest request){
        //无关代码都省略了
        //int unReadNewsCount = adminService.getUnReadNews(username);
        systemWebSocketHandler().sendMessageToUser("xq", new TextMessage(5 + ""));
        return "123";
    }
}