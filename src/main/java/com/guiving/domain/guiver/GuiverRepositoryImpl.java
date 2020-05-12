package com.guiving.domain.guiver;

import com.guiving.vo.Name;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.GuiverType;
import com.guiving.vo.enums.status.GuiverStatus;
import com.guiving.web.dto.guiver.GuiverSearchDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.guiving.domain.guiver.QGuiver.guiver;

@RequiredArgsConstructor
public class GuiverRepositoryImpl implements GuiverRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Guiver> findByName(Name name) {
        return queryFactory
                .selectFrom(guiver)
                .where(guiver.name.eq(name))
                .fetch();
    }

    @Override
    public Page<Guiver> searchAll(GuiverSearchDto search, Pageable pageable){
        QueryResults<Guiver> result = queryFactory
                .selectFrom(guiver)
                .where(eqCity(search.getCityCode()),
                        eqStatus(search.getStatus()),
                        eqType(search.getType()),
                        eqCompany(search.getType(),search.getCompanyId())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }
    private BooleanExpression eqCity(CityCode cityCode) {
        if (ObjectUtils.isEmpty(cityCode)) {
            return null;
        }
        return guiver.city.code.eq(cityCode);
    }
    private BooleanExpression eqStatus(GuiverStatus status) {
        if (ObjectUtils.isEmpty(status)) {
            return null;
        }
        return guiver.status.eq(status);
    }
    private BooleanExpression eqCompany(GuiverType type,Long companyId) {
        if (ObjectUtils.isEmpty(type)) {
            return null;
        }
        if (type.equals(GuiverType.FREELANCER) || ObjectUtils.isEmpty(companyId)) {
            return null;
        }
        return guiver.company.id.eq(companyId);
    }
    private BooleanExpression eqType(GuiverType type) {
        if (ObjectUtils.isEmpty(type)) {
            return null;
        }
        return guiver.type.eq(type);
    }


}
