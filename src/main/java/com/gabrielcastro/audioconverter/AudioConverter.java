package com.gabrielcastro.audioconverter;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class AudioConverter {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {

        AudioLoader loader = new AudioLoader();

        File dir = new File("/home/gabriel/Documentos/cd/audio-converter/files");
        File[] files = dir.listFiles();
        for (File file : files) {
            String path = file.getAbsolutePath();
            loader.convertToMp3(path);
        }
    }
}
