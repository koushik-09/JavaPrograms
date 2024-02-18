package koushik.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.imageio.ImageIO;

public class ImageEncryption {

    public static void main(String[] args) {
        try {
            // Step 1: Generate RSA key pair
            KeyPair keyPair = generateRSAKeyPair();

            // Step 2: Load and prepare the image
            BufferedImage originalImage = loadImage("C:\\Users\\kittu\\IdeaProjects\\JavaPrograms\\src\\koushik\\project\\ImageSecurity.jpg");
            byte[] imageBytes = convertImageToBytes(originalImage);

            // Step 3: Encrypt the image using RSA
            byte[] encryptedImage = encryptWithRSA(imageBytes, keyPair.getPublic());

            // Step 4: Generate a Chaos-based encryption key
            byte[] chaosKey = generateChaosKey(encryptedImage.length);

            // Step 5: Encrypt the image with the Chaos key (e.g., XOR)
            byte[] finalEncryptedImage = applyChaosEncryption(encryptedImage, chaosKey);

            // Step 6: Save the encrypted image
            //saveBytesAsImage(finalEncryptedImage, "encrypted_image.jpg");

            // Decryption follows the reverse process using the private key
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static BufferedImage loadImage(String filePath) throws IOException {
        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            throw new IOException("Image file not found at the specified path: " + filePath);
        }
        BufferedImage image = ImageIO.read(imageFile);
        if (image == null) {
            throw new IOException("Failed to load the image at the specified path: " + filePath);
        }
        return image;
    }

    private static byte[] convertImageToBytes(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!ImageIO.write(image, "JPEG", byteArrayOutputStream)) {
            throw new IOException("Failed to convert the image to bytes.");
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] encryptWithRSA(byte[] data, PublicKey publicKey) throws Exception {
        // Generate a symmetric key (e.g., AES)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // You can choose the key size (e.g., 128, 256 bits)
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt the data with the symmetric key
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data);

        // Encrypt the symmetric key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedSymmetricKey = rsaCipher.doFinal(secretKey.getEncoded());

        // Combine the encrypted symmetric key and the encrypted data
        byte[] combined = new byte[encryptedSymmetricKey.length + encryptedData.length];
        System.arraycopy(encryptedSymmetricKey, 0, combined, 0, encryptedSymmetricKey.length);
        System.arraycopy(encryptedData, 0, combined, encryptedSymmetricKey.length, encryptedData.length);

        return combined;
    }

    private static byte[] generateChaosKey(int length) {
        byte[] chaosKey = new byte[length];
        for (int i = 0; i < length; i++) {
            chaosKey[i] = (byte) (Math.random() * 256);
        }
        return chaosKey;
    }

    private static byte[] applyChaosEncryption(byte[] data, byte[] chaosKey) {
        int length = Math.min(data.length, chaosKey.length);
        byte[] encryptedData = new byte[length];
        for (int i = 0; i < length; i++) {
            encryptedData[i] = (byte) (data[i] ^ chaosKey[i]);
        }
        return encryptedData;
    }

    private static void saveBytesAsImage(byte[] data, String filePath, int maxWidth, int maxHeight) throws IOException {
        BufferedImage image = new BufferedImage(1, data.length, BufferedImage.TYPE_BYTE_GRAY);
        image.getRaster().setDataElements(0, 0, 1, data.length, data);

        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();

        if (originalWidth > maxWidth || originalHeight > maxHeight) {
            double scaleFactor = Math.min((double) maxWidth / originalWidth, (double) maxHeight / originalHeight);
            int newWidth = (int) (originalWidth * scaleFactor);
            int newHeight = (int) (originalHeight * scaleFactor);

            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g = resizedImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newWidth, newHeight, 0, 0, originalWidth, originalHeight, null);
            g.dispose();
            image = resizedImage;
        }

        File imageFile = new File(filePath);
        ImageIO.write(image, "jpg", imageFile);
        System.out.println("Image saved to: " + filePath);
    }
}
