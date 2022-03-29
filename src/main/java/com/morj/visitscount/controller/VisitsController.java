package com.morj.visitscount.controller;

import com.morj.visitscount.model.Response;
import com.morj.visitscount.redis.RedisClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                redisClient.increment("GET")
        );
    }

    @PostMapping("/")
    public Response postVisits() {
        return new Response(
                "POST",
                "Amount of times 'POST' method was used",
                redisClient.increment("POST")
        );
    }
}
