package net.kr9ly.rxproperty;

import org.junit.Test;

import static org.junit.Assert.*;

public class RxFieldTest {

    @Test
    public void testUpdate() {
        RxField<String> field = RxField.create("test");

        field.asObserver().onNext("test2");

        assertEquals("test2", field.getValue().get());
    }
}
