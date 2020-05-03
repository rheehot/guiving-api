package com.guiving.domain.vo;

import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {

    @Test
    public void isValid() {
        Name name = Name.builder().firstName("sdfsdf").lastName("").build();
        System.out.println("isValid : " + name.isValid());
    }
}