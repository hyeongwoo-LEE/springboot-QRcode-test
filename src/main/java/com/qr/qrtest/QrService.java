package com.qr.qrtest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@Service
public class QrService {

    public void qrCreate(String fileName) throws WriterException, IOException {

        // QRCode 색상값
        int qrcodeColor =   0xFF2e4e96;
        // QRCode 배경색상값
        int backgroundColor = 0xFFFFFFFF;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix qr = qrCodeWriter.encode("guddn", BarcodeFormat.QR_CODE, 200, 200);
        MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig();

        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qr, matrixToImageConfig);

        //폴더 생성
        File qrFolder = makeFolder("qrFolder");

        //파일 저장
        File storeFile = new File(qrFolder, fileName+".png");

        ImageIO.write(qrImage,"png", storeFile);

    }

    private File makeFolder(String folderName) {
        String uploadFolder = System.getProperty("user.home");

        File uploadPathFolder = new File(uploadFolder, folderName);

        if(uploadPathFolder.exists() == false){
            uploadPathFolder.mkdirs();
        }

        return uploadPathFolder;
    }
}
