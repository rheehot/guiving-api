package com.guiving.vo.enums;

import com.guiving.interfaces.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum FileCode implements CodeEnum{

    DTI("500C01",FileType.COMPANY,"DTI, Department of Trade in Industry"),
    MPT("500C02",FileType.COMPANY,"Mayors Permit"),
    COR("500C03",FileType.COMPANY,"COR, Certificate of Registration from the Bureau of Internal Revenue"),
    DOT("500C04",FileType.COMPANY,"Department of Tourism Accreditation of the company"),
    LTF("500C05",FileType.COMPANY,"LTFRB franchise permit");

    private final String code;
    private final FileType parentCode;
    private final String comment;

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getCode() {
        return code;
    }

    public FileType getParentCode() {
        return parentCode;
    }

    @ToString
    @AllArgsConstructor
    public enum FileType implements CodeEnum {

        COMPANY("500C", "업체자료"),
        DRIVER("500D", "드라이버자료"),
        CUSTOMER("500U", "고객자료"),
        VEHICLE("500V", "차량자료");

        private final String code;
        private final String comment;

        @Override
        public String getComment() {
            return comment;
        }

        @Override
        public String getKey() {
            return name();
        }

        @Override
        public String getCode() {
            return code;
        }


    }

}