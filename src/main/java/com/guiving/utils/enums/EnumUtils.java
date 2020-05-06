package com.guiving.utils.enums;

import com.guiving.vo.enums.Gender;
import com.guiving.vo.enums.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EnumUtils {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private static EnumMapper enumMapper;
    @Bean
    private EnumMapper enumMapper() {
        EnumUtils.enumMapper = new EnumMapper();
        enumMapper.put("Gender", Gender.class);
        enumMapper.put("Language", Language.class);
        return enumMapper;
    }
    public static EnumMapper getMapper() {
        return enumMapper;
    }
}
