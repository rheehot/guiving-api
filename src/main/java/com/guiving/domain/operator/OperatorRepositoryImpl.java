package com.guiving.domain.operator;

import com.guiving.domain.guiver.Guiver;
import com.guiving.domain.guiver.GuiverRepositoryCustom;
import com.guiving.vo.Name;
import com.guiving.vo.enums.CityCode;
import com.guiving.vo.enums.GuiverType;
import com.guiving.vo.enums.status.GuiverStatus;
import com.guiving.vo.enums.status.OperatorStatus;
import com.guiving.web.dto.guiver.GuiverSearchDto;
import com.guiving.web.dto.operator.OperatorSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.guiving.domain.operator.QOperator.operator;

@RequiredArgsConstructor
public class OperatorRepositoryImpl implements OperatorRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Operator> searchAll(OperatorSearchDto search, Pageable pageable){
        QueryResults<Operator> result = queryFactory
                .selectFrom(operator)
                .where(
                        eqStatus(search.getStatus()),
                        eqCompany(search.getCompanyId())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(),pageable,result.getTotal());
    }

    private BooleanExpression eqStatus(OperatorStatus status) {
        if (ObjectUtils.isEmpty(status)) {
            return null;
        }
        return operator.status.eq(status);
    }
    private BooleanExpression eqCompany(Long companyId) {

        if (ObjectUtils.isEmpty(companyId)) {
            return null;
        }
        return operator.company.id.eq(companyId);
    }



}
