package edu.isi.cleancode.validation;

import java.util.ArrayList;
import java.util.List;


public class ValResult {
    private final List<String> errors = new ArrayList<>();

    public void addError(String message) {
        errors.add(message);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }


}
