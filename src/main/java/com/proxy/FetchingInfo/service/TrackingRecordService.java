package com.proxy.FetchingInfo.service;

import com.proxy.FetchingInfo.entity.TrackingDetails;
import com.proxy.FetchingInfo.repository.TrackingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingRecordService {

    @Autowired
    private TrackingDetailsRepository trackingDetailsRepository;

    public List<TrackingDetails> getAll() {
        return trackingDetailsRepository.findAll();
    }
}
