package com.guiving.domain.vehicle;

import com.guiving.vo.enums.CarGrade;
import com.guiving.vo.enums.OwnType;
import com.guiving.vo.enums.status.VehicleStatus;
import com.guiving.web.dto.vehicle.VehicleSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import static com.guiving.domain.vehicle.QVehicle.vehicle;

@RequiredArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    @Override
    public Page<Vehicle> searchAll(VehicleSearchDto search, Pageable pageable){
        QueryResults<Vehicle> result = queryFactory
                .selectFrom(vehicle)
                .where(
                        eqGrade(search.getGrade()),
                        eqStatus(search.getStatus()),
                        eqOwnType(search.getOwnType()),
                        eqCompany(search.getOwnType(),search.getCompanyId())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }

    private BooleanExpression eqGrade(CarGrade grade) {
        if (ObjectUtils.isEmpty(grade)) {
            return null;
        }
        return vehicle.carModel.grade.eq(grade);
    }
    private BooleanExpression eqCompany(OwnType ownType,Long companyId) {
        if (ObjectUtils.isEmpty(ownType)) {
            return null;
        }
        if (ownType.equals(OwnType.PERSONAL) || ObjectUtils.isEmpty(companyId)) {
            return null;
        }
        return vehicle.company.id.eq(companyId);
    }
    private BooleanExpression eqStatus(VehicleStatus status) {
        if (ObjectUtils.isEmpty(status)) {
            return null;
        }
        return vehicle.status.eq(status);
    }
    private BooleanExpression eqOwnType(OwnType ownType) {
        if (ObjectUtils.isEmpty(ownType)) {
            return null;
        }
        return ownType.equals(OwnType.BUSINESS)?vehicle.company.isNotNull():vehicle.guiver.isNotNull();
    }


}
