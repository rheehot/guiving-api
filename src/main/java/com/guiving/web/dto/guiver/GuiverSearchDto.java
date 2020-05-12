package com.guiving.web.dto.guiver;

import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.GuiverType;
import com.guiving.vo.enums.status.GuiverStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@ToString
public class GuiverSearchDto {
    private CityCode cityCode;
    private GuiverType type;
    private Long companyId;
    private GuiverStatus status;

    @Builder
    public GuiverSearchDto(CityCode cityCode, GuiverType type, Long companyId, GuiverStatus status) {
        this.cityCode = cityCode;
        this.type = type;
        this.companyId = companyId;
        this.status = status;
    }
}
