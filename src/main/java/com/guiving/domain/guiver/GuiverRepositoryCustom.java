package com.guiving.domain.guiver;

import com.guiving.vo.Name;
import com.guiving.web.dto.guiver.GuiverSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface GuiverRepositoryCustom {
    List<Guiver> findByName(Name name);
    Page<Guiver> searchAll(GuiverSearchDto search, Pageable pageable);
}
