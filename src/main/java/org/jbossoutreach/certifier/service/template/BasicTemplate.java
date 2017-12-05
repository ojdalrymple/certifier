package org.jbossoutreach.certifier.service.template;

import org.jbossoutreach.certifier.model.Student;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BasicTemplate implements Template {
    @Override
    public InputStream buildTemplate(Student student) {
        final String template = "<html>" +
                "<head>" +
                "<title>" +
                "Certificate" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<table width=\"100%\"  style='border-collapse: collapse; color:rgb(51,153,255); background:rgb(230,230,230);'>" +
                "<tr>" +
                "<td style=\" height:800px; padding:20px; text-align:center; border: 10px solid #787878\">" +
                "<span style=\"font-size:50px; font-weight:bold\">Certificate of Completion</span>" +
                "<br/><br/>" +
                "<span style=\"font-size:25px\"><i>This is to certify that</i></span>" +
                "<br/><br/>" +
                "<span style=\"font-size:30px\"><b>" + student.getName() + "</b></span><br/><br/>" +
                "<span style=\"font-size:25px\"><i>has completed the course</i></span> <br/><br/>" +
                "<span style=\"font-size:30px\">" + student.getTitle() + "</span> <br/><br/>" +
                "<span style=\"font-size:20px\">with score of <b>" + student.getScore() + "</b></span>" +
                "<br/><br/><br/><br/>" +
                "<span style=\"font-size:25px\"><i>dated</i></span><br/>" +
                student.getAwardDate() +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>";
        return new ByteArrayInputStream(template.getBytes());
    }
}
