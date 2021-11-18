package com.example.boot.jar.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ParsePDF {


    @Test
    public void t1() {
        try {
            String fileName = "C:\\Users\\xxb\\Desktop\\1.pdf";
            File file = new File("C:\\Users\\xxb\\Desktop\\2.pdf");
            //加载现有的PDF文件
            PDDocument document = PDDocument.load(file);
            //Stripper 类提供了从PDF检索文本的方法
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setWordSeparator("|");
//        stripper.setStartPage(1);
//        int pages = document.getNumberOfPages();
//        stripper.setEndPage(pages);
            String text = stripper.getText(document);
            System.out.println(text);
            document.close();
        }catch (Exception e){
            System.out.println(e);
        }


    }

}
