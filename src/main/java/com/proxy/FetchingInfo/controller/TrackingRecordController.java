package com.proxy.FetchingInfo.controller;

import com.proxy.FetchingInfo.entity.TrackingDetails;
import com.proxy.FetchingInfo.repository.TrackingDetailsRepository;
import com.proxy.FetchingInfo.service.TrackingRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class TrackingRecordController {

    private TrackingRecordService trackingRecordService;

    public TrackingRecordController(TrackingRecordService trackingRecordService) {
        this.trackingRecordService = trackingRecordService;
    }

    @GetMapping("/all")
    public List<TrackingDetails> getAll() {
        return trackingRecordService.getAll();
    }

}
