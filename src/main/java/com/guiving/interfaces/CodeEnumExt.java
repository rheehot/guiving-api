package com.guiving.interfaces;

public interface CodeEnumExt extends CodeEnum{
    <T extends Enum<T> & CodeEnum> T getParentCode();
}
