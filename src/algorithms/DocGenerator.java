/*
 * Copyright (c)  2018. Garvit Kothari
 */

package algorithms;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import java.io.File;
import java.io.FileOutputStream;

public class DocGenerator {
    private void newParagraph(XWPFDocument doc,String str) {
        //Paragraph
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(str);
    }
    private void newHeaderFooter(XWPFDocument doc,String headerStr,String footerStr) {
        CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(doc,sectPr);

        // Write Header Content
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        ctHeader.setStringValue(headerStr);
        XWPFParagraph headerPara = new XWPFParagraph(ctpHeader,doc);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerPara;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT,parsHeader);

        // Write Footer Content
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        ctFooter.setStringValue(footerStr);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, doc);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

    }
    public void createDoc() throws Exception {

        XWPFDocument document = new XWPFDocument();
        File file = new File("example.docx");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        newHeaderFooter(document,"Header","Footer");
        newParagraph(document,"Hello World");
        newParagraph(document,"Nice to meet you");

        document.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("Doc Generated !");
    }
    public void getQuestion() {
        String data[][] = ExcelParser.data;

    }
}
