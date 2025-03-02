package br.dev.sbdevtools.api.controller;

import br.dev.sbdevtools.api.model.DocumentModel;
import br.dev.sbdevtools.domain.DocumentCpfGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document-generate")
public class DocumentController {

    @Autowired
    private DocumentCpfGenerateService documentCpfGenerateService;

    @GetMapping("/cpf")
    public ResponseEntity<DocumentModel> generate() {
        return ResponseEntity.ok(documentCpfGenerateService.generateDocumentCpf());
    }

}
