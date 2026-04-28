package com.proxy.FetchingInfo.controller;

import com.proxy.FetchingInfo.service.TrackingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class TrackingController {

    private final TrackingService service;

    private static final Logger logger =
            LoggerFactory.getLogger(TrackingController.class);

    @GetMapping("/track")
    public void trackClick(
            @RequestParam String id,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        String ip = request.getRemoteAddr();

        logger.info("Tracking link clicked. trackingId={}, ip={}", id, ip);

        service.saveTracking(id, request);

        logger.info("Redirecting user to destination URL");

        response.sendRedirect("https://youtube.com");
    }
}