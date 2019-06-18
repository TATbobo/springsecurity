package com.tucker.securitycore;

import com.tucker.securitycore.validate.ValidateCodeProcessorHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityCoreApplicationTests {

    @Autowired
    ValidateCodeProcessorHolder validateCodeProcessorHolder;

    @Test
    public void contextLoads() {
        System.out.println(validateCodeProcessorHolder.getA());
    }

}
