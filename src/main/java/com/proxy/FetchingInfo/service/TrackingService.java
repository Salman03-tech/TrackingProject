package com.proxy.FetchingInfo.service;

import com.proxy.FetchingInfo.entity.TrackingDetails;
import com.proxy.FetchingInfo.repository.TrackingDetailsRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrackingService {

    private final TrackingDetailsRepository trackingDetailsRepository;
    private final GeoLocation geoLocation;

    public void saveTracking(
            String trackingId,
            HttpServletRequest request
    ) {

        String ipAddress = getClientIp(request);

        Map<String, Object> geoData = geoLocation.getLocation(ipAddress);

        TrackingDetails tracking = new TrackingDetails();
        tracking.setTrackingId(trackingId);
        tracking.setIpAddress(ipAddress);
        tracking.setLatitude(String.valueOf(geoData.get("lat")));
        tracking.setLongitude(String.valueOf(geoData.get("lon")));
        tracking.setCity((String) geoData.get("city"));
        tracking.setRegion((String) geoData.get("regionName"));
        tracking.setCountry((String) geoData.get("country"));
        tracking.setClickedAt(LocalDateTime.now());

        trackingDetailsRepository.save(tracking);
    }

    private String getClientIp(HttpServletRequest request) {

        String xfHeader =
                request.getHeader("X-Forwarded-For");

        if (xfHeader == null)
            return request.getRemoteAddr();

        return xfHeader.split(",")[0];
    }
}