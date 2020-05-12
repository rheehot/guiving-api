package com.guiving.domain.vehicle;

import com.guiving.web.dto.vehicle.VehicleSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface VehicleRepositoryCustom {
    Page<Vehicle> searchAll(VehicleSearchDto search, Pageable pageable);
}
