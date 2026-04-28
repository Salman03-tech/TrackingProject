package com.proxy.FetchingInfo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tracking_details")
public class TrackingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String trackingId;

    private String ipAddress;

    private String latitude;

    private String longitude;

    private String city;

    private String region;

    private String country;

    private LocalDateTime clickedAt;

}
