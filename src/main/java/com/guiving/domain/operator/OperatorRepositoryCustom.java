package com.guiving.domain.operator;

import com.guiving.domain.guiver.Guiver;
import com.guiving.vo.Name;
import com.guiving.web.dto.guiver.GuiverSearchDto;
import com.guiving.web.dto.operator.OperatorSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OperatorRepositoryCustom {
    Page<Operator> searchAll(OperatorSearchDto search, Pageable pageable);
}
