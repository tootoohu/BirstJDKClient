package com.infor.connect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.log4j.Logger;
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
public class EncryptionService {
    private static EncryptionService instance;
    private static String key;
    private static boolean useBCFIPS;
    private static final Logger logger = Logger.getLogger(EncryptionService.class);

    private EncryptionService() {
    }

    public static synchronized EncryptionService getInstance() {
        if (instance == null) {
            instance = new EncryptionService();
        }

        return instance;
    }

    public static void setKey(String response) {
        try {
            BufferedReader reader = new BufferedReader(new StringReader(response));
            String line = null;

            while((line = reader.readLine()) != null) {
                if (line.startsWith("encryptionkey=")) {
                    key = line.substring("encryptionkey=".length());
                }
            }
        } catch (IOException var3) {
            logger.error((Object)null, var3);
        }

    }

    public static SSLSocketFactory getSSLSocketFactory() throws Exception {
        SSLContext clientContext = SSLContext.getInstance("TLS");
        if (useBCFIPS) {
            clientContext.init((KeyManager[])null, (TrustManager[])null, SecureRandom.getInstance("DEFAULT", "BCFIPS"));
        } else {
            clientContext.init((KeyManager[])null, (TrustManager[])null, new SecureRandom());
        }

        return clientContext.getSocketFactory();
    }

    public static SSLSocketFactory getSSLSocketFactoryWithoutValidation() throws Exception {
        TrustManager[] trustAll = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};
        SSLContext sslContext = SSLContext.getInstance("TLS");
        if (useBCFIPS) {
            sslContext.init((KeyManager[])null, trustAll, SecureRandom.getInstance("DEFAULT", "BCFIPS"));
        } else {
            sslContext.init((KeyManager[])null, trustAll, new SecureRandom());
        }

        return sslContext.getSocketFactory();
    }

    public String decrypt(String text) {
        return this.decrypt(text, key);
    }

    public synchronized String decrypt(String text, String password) {
        if (text == null) {
            return null;
        } else {
            try {
                Cipher cipher;
                if (useBCFIPS) {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BCFIPS");
                } else {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }

                byte[] keyBytes = new byte[16];
                byte[] b = password.getBytes("UTF-8");
                int len = b.length;
                if (len > keyBytes.length) {
                    len = keyBytes.length;
                }

                System.arraycopy(b, 0, keyBytes, 0, len);
                SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
                cipher.init(2, keySpec, ivSpec);
                byte[] results = cipher.doFinal(Base64Encoder.decode(text.getBytes("UTF-8")));
                return new String(results, "UTF-8");
            } catch (Exception var10) {
                logger.error("Decryption failed", var10);
                return null;
            }
        }
    }

    public String encrypt(String text) {
        return this.encrypt(text, key);
    }

    private synchronized String encrypt(String text, String password) {
        if (text == null) {
            return null;
        } else {
            try {
                Cipher cipher;
                if (useBCFIPS) {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BCFIPS");
                } else {
                    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }

                byte[] keyBytes = new byte[16];
                byte[] b = password.getBytes("UTF-8");
                int len = b.length;
                if (len > keyBytes.length) {
                    len = keyBytes.length;
                }

                System.arraycopy(b, 0, keyBytes, 0, len);
                SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
                cipher.init(1, keySpec, ivSpec);
                byte[] inputBytes = text.getBytes("UTF8");
                byte[] outputBytes = cipher.doFinal(inputBytes);
                return new String(Base64Encoder.encodebytes(outputBytes), "UTF-8");
            } catch (Exception var11) {
                logger.error("Encryption failed", var11);
                return null;
            }
        }
    }

    static {
        try {
            Class.forName("javax.jnlp.ServiceManager");
            useBCFIPS = false;
            logger.warn("FIPS 140-2 compliance is disabled under Java Web Start");
        } catch (ClassNotFoundException var2) {
            String bcfipsFlag = System.getProperty("bcfips");
            if (bcfipsFlag == null) {
                useBCFIPS = false;
            } else if (bcfipsFlag.length() == 0) {
                useBCFIPS = true;
            } else {
                useBCFIPS = Boolean.parseBoolean(bcfipsFlag);
            }

            if (useBCFIPS) {
                Security.addProvider(new BouncyCastleFipsProvider());
                logger.info("FIPS 140-2 compliance is enabled");
            } else {
                logger.warn("FIPS 140-2 compliance is not enabled");
            }
        }

    }
}
