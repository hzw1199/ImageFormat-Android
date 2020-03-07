package com.wuadam.imageformat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.wuadam.imageformat.FormatHelper.FORMAT.GIF;
import static com.wuadam.imageformat.FormatHelper.FORMAT.JPG;
import static com.wuadam.imageformat.FormatHelper.FORMAT.PNG;
import static com.wuadam.imageformat.FormatHelper.FORMAT.WEBP;

public class FormatHelper {

    public enum FORMAT{
        JPG("jpg"), PNG("png"), WEBP("webp"), GIF("gif");
        public String extension;

        FORMAT(String extension) {
            this.extension = extension;
        }
    }

    private FormatHelper() {
    }

    public static FORMAT getFormat(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            return getFormat(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FORMAT getFormat(InputStream inputStream) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(Integer.MAX_VALUE);
            byte[] start;
            byte[] end;

            // https://en.wikipedia.org/wiki/JPEG
            start = new byte[2];
            bufferedInputStream.read(start);
            if (start[0] == (byte) 0xFF &&
                    start[1] == (byte) 0xD8
            ) {
                return JPG;
            }
            bufferedInputStream.reset();

            // https://en.wikipedia.org/wiki/Portable_Network_Graphics
            start = new byte[8];
            bufferedInputStream.read(start);
            if (start[0] == (byte) 0x89 &&
                    start[1] == (byte) 0x50 &&
                    start[2] == (byte) 0x4E &&
                    start[3] == (byte) 0x47 &&
                    start[4] == (byte) 0x0D &&
                    start[5] == (byte) 0x0A &&
                    start[6] == (byte) 0x1A &&
                    start[7] == (byte) 0x0A) {
                return PNG;
            }
            bufferedInputStream.reset();

            // https://developers.google.com/speed/webp/docs/riff_container
            // https://en.wikipedia.org/wiki/WebP
            start = new byte[4];
            end = new byte[4];
            bufferedInputStream.read(start);
            bufferedInputStream.skip(4);
            bufferedInputStream.read(end);
            if (start[0] == (byte) 0x52 &&
                    start[1] == (byte) 0x49 &&
                    start[2] == (byte) 0x46 &&
                    start[3] == (byte) 0x46 &&
                    end[0] == (byte) 0x57 &&
                    end[1] == (byte) 0x45 &&
                    end[2] == (byte) 0x42 &&
                    end[3] == (byte) 0x50) {
                return WEBP;
            }
            bufferedInputStream.reset();

            // https://en.wikipedia.org/wiki/File:Empty_GIF_hex.png
            start = new byte[6];
            bufferedInputStream.read(start);
            if (start[0] == (byte) 0x47 &&
                    start[1] == (byte) 0x49 &&
                    start[2] == (byte) 0x46 &&
                    start[3] == (byte) 0x38 &&
                    start[4] == (byte) 0x39 &&
                    start[5] == (byte) 0x61) {
                return GIF;
            }

            bufferedInputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
