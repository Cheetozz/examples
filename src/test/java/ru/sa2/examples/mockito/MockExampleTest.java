package ru.sa2.examples.mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alexander Smirnov (AlVyaSmirnov) on 22.09.2015.
 * email: asmirnov@vrn.beeline.ru
 */
class MockExampleTest {

    public static void main(String[] args) {

        MockExample me = createMock();

        System.out.println(me.stringFormat("bla-bla-bla"));
        System.out.println(me.stringFormat("one"));
        System.out.println(me.stringFormat("sdfsdfsdfsdfsdfsdf"));
    }

    public static MockExample createMock(){

        MockExample testMock = mock(MockExample.class);

        when(testMock.stringFormat(anyString())).thenReturn("KLLKD:KJS:DJFH:SDJLHF");
        when(testMock.stringFormat("one")).thenReturn("one-two-джигурда");

        return testMock;
    }

}
