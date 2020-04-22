package com.guiving.utils.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.guiving.interfaces.CodeEnum;
import com.guiving.domain.vo.enums.status.web.dto.EnumValueDto;

public class EnumMapper {
    private Map<String, List<EnumValueDto>> factory = new HashMap<>();

    private List<EnumValueDto> toEnumValues(Class<? extends CodeEnum> e){
        // Java8이 아닐경우
//            List<EnumValue> enumValues = new ArrayList<>();
//            for (CodeEnum enumType : e.getEnumConstants()) {
//                enumValues.add(new EnumValue(enumType));
//            }
//            return enumValues;

        return Arrays
                .stream(e.getEnumConstants())
                .map(EnumValueDto::new)
                .collect(Collectors.toList());
    }

    public void put(String key, Class<? extends CodeEnum> e){
        factory.put(key, toEnumValues(e));
    }

    public Map<String, List<EnumValueDto>> getAll(){
        return factory;
    }

    public Map<String, List<EnumValueDto>> get(String keys){

        // Java8이 아닐경우
//            Map<String, List<EnumValue>> result = new LinkedHashMap<>();
//            for (String key : keys.split(",")) {
//                result.put(key, factory.get(key));
//            }
//
//            return result;

        return Arrays
                .stream(keys.split(","))
                .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }
}
