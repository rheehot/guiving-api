package com.guiving.web.dto.vehicle;

import com.guiving.vo.Picture;
import com.guiving.vo.enums.CarGrade;
import com.guiving.vo.enums.OwnType;
import com.guiving.vo.enums.status.VehicleStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VehicleSearchDto {
    private CarGrade grade;
    private OwnType ownType;
    private Long companyId;
    private VehicleStatus status;

    @Builder
    public VehicleSearchDto(CarGrade grade, OwnType ownType, Long companyId, VehicleStatus status) {
        this.grade = grade;
        this.ownType = ownType;
        this.companyId = companyId;
        this.status = status;
    }
}
