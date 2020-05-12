package com.guiving.domain.company;

import com.guiving.domain.guiver.Guiver;
import com.guiving.vo.Name;
import com.guiving.web.dto.company.CompanySearchDto;
import com.guiving.web.dto.guiver.GuiverSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyRepositoryCustom {
    Page<Company> searchAll(CompanySearchDto search, Pageable pageable);
}
