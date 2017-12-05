package org.jbossoutreach.certifier.service.generator;

import org.jbossoutreach.certifier.model.Student;

/**
 * An interface for a certificate generator.
 */
public interface CertGenerator {
    public String generateCert(Student student) throws Exception;
}
