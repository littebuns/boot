package com.example.boot.jar.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ParsePDF {


    @Test
    public void t1() {
        try {
            String fileName = "C:\\Users\\xxb\\Desktop\\2.pdf";
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            System.out.println(file.getName());
            //加载现有的PDF文件
            PDDocument document = PDDocument.load(inputStream);
            //Stripper 类提供了从PDF检索文本的方法
            PDFTextStripper stripper = new PDFTextStripper();
//            stripper.setWordSeparator("|");
            String text = stripper.getText(document);
            System.out.println(text);
            document.close();
        }catch (Exception e){
            System.out.println(e);
        }


    }

}
