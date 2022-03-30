package com.morj.visitscount.controller;

import com.morj.visitscount.model.Response;
import com.morj.visitscount.redis.RedisClient;
import com.morj.visitscount.time.Clockwork;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class VisitsController {

    private final RedisClient redisClient;

    @GetMapping("/")
    public Response getVisits() {
        return new Response(
                "GET",
                "Amount of times 'GET' method was used",
                redisClient.get("GET")
        );
    }

    @PostMapping("/")
    public Response postVisits() {
        return new Response(
                "POST",
                "Amount of times 'POST' method was used",
                redisClient.get("POST")
        );
    }

    @GetMapping("/ip")
    public Response ip(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        return new Response(
                remoteAddr,
                "Amount of times application was visited from this IP address",
                redisClient.get(remoteAddr)
        );
    }

    @GetMapping("/agent")
    public Response agent(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return new Response(
                userAgent,
                "Amount of times application was visited from this 'User-Agent'",
                redisClient.get(userAgent)
        );
    }

    @GetMapping("/time")
    public Response time(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        return new Response(
                remoteAddr,
                "Last time you visited application from your current IP address",
                redisClient.getSet("time_" + remoteAddr, Clockwork.getTime())
        );
    }
}
