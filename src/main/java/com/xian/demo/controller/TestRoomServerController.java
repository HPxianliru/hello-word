package com.xian.demo.controller;


import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author live-team@xian.com
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/test")
public class TestRoomServerController {

    /**
     * 查询房间 by 房间信息
     *
     * @param
     * @return
     */
    @GetMapping("/hello/{name}")
    @Trace
    public String findRoomById(String name) {
        System.out.println("traceId:" + TraceContext.traceId());
        ActiveSpan.tag("hello-trace activation", name);
        return name+"hello word!";
    }


    /**
     * 查询房间 by 房间信息
     *
     * @param
     * @return
     */
    @Trace
    @GetMapping("/err")
    public String err() {
        String traceId = TraceContext.traceId();
        System.out.println("traceId:" + TraceContext.traceId());
        ActiveSpan.tag("error-trace activation", traceId);
        throw new RuntimeException("err");
    }


}

