package com.guiving.utils.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumValueConvertUtils {
    public static <T extends Enum<T> & CodeEnum> T ofDBCode(Class<T> enumClass, String dbCode){
        if(StringUtils.isBlank(dbCode))
            return null;

        return EnumSet.allOf(enumClass).stream()
                .filter(v -> v.getCode().equals(dbCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("enum=[%s], code=[%s]가 존재하지 않습니다.",enumClass.getName(),dbCode)));
    }

    public static <T extends Enum<T> & CodeEnum> String toDBcode(T enumValue) {
        if(enumValue == null)
            return "";


        return enumValue.getCode();
    }
}
