package com.example.PDF_GENERATOR;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;

@Service
public class PdfService {

    private final TemplateEngine templateEngine;
    private final ResourceLoader resourceLoader;

    @Autowired
    public PdfService(TemplateEngine templateEngine, ResourceLoader resourceLoader) {
        this.templateEngine = templateEngine;
        this.resourceLoader = resourceLoader;
    }

    public String generatePdf(PdfData data) {
        try {
            String htmlContent = generateHtmlContent(data);
            String filePath = "generated-pdf.pdf";

            try (OutputStream outputStream = new FileOutputStream(filePath)) {
                ConverterProperties converterProperties = new ConverterProperties();
                converterProperties.setBaseUri("src/main/resources/templates/");

                HtmlConverter.convertToPdf(htmlContent, outputStream, converterProperties);
            }

            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating PDF");
        }
    }

    private String generateHtmlContent(PdfData data) {
        Context context = new Context();
        context.setVariable("data", data);

        return templateEngine.process("pdf-template", context);
    }

    public Resource loadPdfResource(String fileName) throws FileNotFoundException {
        Resource resource = resourceLoader.getResource("file:" + fileName);

        if (resource.exists()) {
            return resource;
        } else {
            throw new FileNotFoundException("PDF file not found: " + fileName);
        }
    }
}
