package com.nascar.rest.data.jpa.service;

import com.nascar.rest.data.jpa.domain.Pitstop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "pitstops", path = "pitstops")
public interface PitstopRepository extends PagingAndSortingRepository<Pitstop, Long> {
    @RestResource(path = "vehicle", rel = "byVehicle")
    List<Pitstop> findByVehicleNumber(@Param("number") int vehicleNumber);

    @Override
    @RestResource(exported = false)
    void delete(Pitstop pitstop);
}