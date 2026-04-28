package com.proxy.FetchingInfo.repository;

import com.proxy.FetchingInfo.entity.TrackingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingDetailsRepository extends JpaRepository<TrackingDetails, Long> {
}
