package com.thiago.teste;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.PageGuruRegister;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(InvokedMethodListener.class)
public class GuruRegisterTest {

    @Test
    public void guruRegisterTest() throws Exception{
        new PageGuruRegister()
                .openPage(PageGuruRegister.class, "http://demo.guru99.com/test/newtours/register.php")
                .guruRegister("breno");
    }
}
