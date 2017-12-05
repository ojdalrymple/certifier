package org.jbossoutreach.certifier.service.generator;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.jbossoutreach.certifier.model.Student;
import org.jbossoutreach.certifier.service.template.Template;

import java.io.FileOutputStream;

/**
 * An implementation of {@code CertGenerator} that generates a PDF certificate.
 */
public class PdfCertGenerator implements CertGenerator {
    private final String outPath;
    private final Template template;

    public PdfCertGenerator(String outPath, Template template) {
        this.outPath = outPath;
        this.template = template;
    }

    @Override
    public String generateCert(Student student) throws Exception {
        final Document document = new Document(PageSize.A4.rotate());
        final PdfWriter writer;
        writer = PdfWriter.getInstance(document, new FileOutputStream(outPath));

        document.open();
        try {
            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                    template.buildTemplate(student));
        } finally {
            document.close();
        }
        return outPath;
    }
}
