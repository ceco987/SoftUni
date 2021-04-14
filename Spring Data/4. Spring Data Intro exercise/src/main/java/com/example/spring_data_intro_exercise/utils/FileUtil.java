package com.example.spring_data_intro_exercise.utils;

import java.io.IOException;

public interface FileUtil {
    String[] readFileContent(String filePath) throws IOException;
}
