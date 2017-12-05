package org.jbossoutreach.certifier.service;

import org.jbossoutreach.certifier.model.Student;
import org.jbossoutreach.certifier.service.generator.CertGenerator;

public class CertManager {
    private final CertGenerator certGenerator;

    public CertManager(CertGenerator certGenerator) {
        this.certGenerator = certGenerator;
    }

    /**
     * Generates a certificate for {@code student} using the provided {@code CertGenerator}
     * @param student to generate a certificate for
     * @return null if generation failed; the String path to the certificate if successful
     */
    public String generateCert(Student student) {
        final String outPath;
        try {
            outPath = certGenerator.generateCert(student);
        } catch (Exception e) {
            return null;
        }
        return outPath;
    }
}
