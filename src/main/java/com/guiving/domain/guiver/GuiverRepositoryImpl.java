package com.guiving.domain.guiver;

import com.guiving.vo.Name;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javafx.beans.binding.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class GuiverRepositoryImpl implements GuiverRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Guiver> findByName(Name name) {
        QGuiver guiver = QGuiver.guiver;
        return queryFactory
                .selectFrom(guiver)
                .where(guiver.name.eq(name))
                .fetch();
    }

    @Override
    public Page<Guiver> searchAll(Pageable pageable){
        QGuiver guiver = QGuiver.guiver;
        QueryResults<Guiver> result = queryFactory
                .selectFrom(guiver)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<Guiver>(result.getResults(),pageable,result.getTotal());

    }




}
