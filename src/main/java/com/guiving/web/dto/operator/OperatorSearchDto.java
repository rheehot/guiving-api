package com.guiving.web.dto.operator;

import com.guiving.domain.operator.Operator;
import com.guiving.vo.Name;
import com.guiving.vo.PhoneNumber;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.Gender;
import com.guiving.vo.enums.JoinType;
import com.guiving.vo.enums.Language;
import com.guiving.vo.enums.status.OperatorStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class OperatorSearchDto {

    private Long companyId;
    private OperatorStatus status;

    @Builder
    public OperatorSearchDto(Long companyId, OperatorStatus status) {
        this.companyId = companyId;
        this.status = status;
    }
}
