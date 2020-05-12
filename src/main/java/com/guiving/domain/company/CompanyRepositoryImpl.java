package com.guiving.domain.company;

import com.guiving.vo.Name;
import com.guiving.vo.enums.CityCode;
import com.guiving.web.dto.company.CompanySearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.guiving.domain.company.QCompany.company;

@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Company> searchAll(CompanySearchDto search, Pageable pageable){
        QueryResults<Company> result = queryFactory
                .selectFrom(company)
                .where(eqCity(search.getCityCode())
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
        return company.city.code.eq(cityCode);
    }



}
