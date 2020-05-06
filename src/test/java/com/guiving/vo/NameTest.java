package com.guiving.vo;

import org.junit.Test;

public class NameTest {

    @Test
    public void isValid() {
        Name name = Name.builder().firstName("sdfsdf").lastName("").build();
        System.out.println("isValid : " + name.isValid());
    }
}