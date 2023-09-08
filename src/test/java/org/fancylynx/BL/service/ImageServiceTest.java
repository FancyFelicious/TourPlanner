package org.fancylynx.BL.service;

import org.fancylynx.application.BL.service.ImageService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageServiceTest {
    @Test
    void testImageSave() throws IOException {
        byte[] imageData = "test".getBytes();

        String result = ImageService.saveImage(imageData);
        Path path = Paths.get(result);

        assertTrue(Files.exists(path));
        byte[] savedImageData = Files.readAllBytes(path);
        String savedImageDataStr = new String(savedImageData);
        String expectedImageDataStr = new String(imageData);
        assertEquals(expectedImageDataStr, savedImageDataStr);

        Files.delete(path);
    }
}
