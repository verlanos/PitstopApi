package com.nascar.rest.data.jpa.service;

import com.nascar.rest.data.jpa.domain.Pitstop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "pitstops", path = "pitstops")
public interface PitstopRepository extends PagingAndSortingRepository<Pitstop, Long> {
    List<Pitstop> findByVehicleNumber(@Param("vehicleNumber") int vehicleNumber);
}