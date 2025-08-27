package com.gabrielcastro.audioconverter;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class AudioLoader {

    public void convertToMp3(String path) throws UnsupportedAudioFileException, IOException {
        File sourceFile = new File(path);
        String newPath = path.replace(sourceFile.getName(), sourceFile.getName().replace(".wav", ".mp3"));
        File outputFile = new File(newPath);
        try {
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(64000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("mp3");
            attrs.setAudioAttributes(audio);

            Encoder encoder = new Encoder();
            encoder.encode(sourceFile, outputFile, attrs);
            System.out.printf("Sucess! Filename: %s%n", outputFile.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
