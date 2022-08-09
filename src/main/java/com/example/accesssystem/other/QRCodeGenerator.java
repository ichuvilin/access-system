package com.example.accesssystem.other;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    private static final String dir = "./src/main/resources/static/img/";


    public void generatorQrCodeImage(String text) throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 250, 250);

        File file = new File(dir + "/" + text + ".png");

        Path path = FileSystems.getDefault().getPath(dir + "/" + text + ".png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
