package com.qr.qrtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QrServiceTest {

    @Autowired QrService qrService;

    @Test
    void crateQr() throws Exception{
        //given

        //when
        qrService.qrCreate("thirdQr");
        //then
    }

}