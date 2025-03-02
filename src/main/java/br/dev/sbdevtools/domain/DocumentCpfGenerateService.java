package br.dev.sbdevtools.domain;

import br.dev.sbdevtools.api.model.DocumentModel;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DocumentCpfGenerateService {

    public DocumentModel generateDocumentCpf(){

        DocumentModel documentModel = new DocumentModel();

        int[] digits = new int[11];
        Random random = new Random();

        digits[0] = random.nextInt(9) + 1;

        for (int i = 1; i < 9; i++) {
            digits[i] = random.nextInt(10);
        }

        digits[9] = calculateVerifierDigit(digits, 10);

        digits[10] = calculateVerifierDigit(digits, 11);

        StringBuilder cpf = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            cpf.append("");
            cpf.append(digits[i]);
        }

        documentModel.setDocument(cpf.toString());

        return documentModel;
    }

    private int calculateVerifierDigit(int[] digits, int length) {
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            sum += digits[i] * (length - i);
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

}
