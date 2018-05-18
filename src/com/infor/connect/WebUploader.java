package com.infor.connect;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class WebUploader {
    private static long SEGMENT_SIZE = 10240000L;
    private static int CHUNK_SIZE = 102400;
    private String url;
    private String username;
    private String password;
    private String space;
    private String uploadToken = null;

    public String uploadFile(String directory, String filename, boolean scan, boolean uploadForScanningOnly) throws Exception {
        File f = new File(directory + File.separator + filename);
        String result = "";
        if(!f.exists()){
            result = "file doesn't exist!";
        }
        int numSegments = (int)Math.ceil((double)f.length() / (double)SEGMENT_SIZE);
        if (numSegments == 0) {

//            df = null;
            return "empty file";
        }

        uploadSegment(false,0, filename,numSegments,f,false, result);

        return result;
    }

    public WebUploader(String userName, String pwd, String space, String url){
        this.url = url;
        this.username = userName;
        this.space = space;
        this.password = pwd;
    }

    public String uploadSegment(boolean usesParallelUpload, int segment, String filename, int numSegments, File f, boolean scan, String result) throws Exception {

        String response = null;
        FileInputStream fis = null;
        HttpURLConnection hs = null;
        BufferedReader in = null;

        try{
        hs = this.setupConnection(this.space, filename, "1");
        hs.setRequestProperty("Content-Type", "application/octet-stream");
        long remainder = f.length() - (long) segment * SEGMENT_SIZE;
        long length = SEGMENT_SIZE;
        if (remainder < 0L) {
            length = Math.min(f.length(), length);
        } else {
            length = Math.min(remainder, length);
        }
        hs.setRequestProperty("Segment-size", Long.toString(SEGMENT_SIZE));
        hs.setRequestProperty("Segment", Integer.toString(segment));
        hs.setRequestProperty("Num-segments", Integer.toString(numSegments));

        if (usesParallelUpload) {
            hs.setRequestProperty("isParallelUpload", Boolean.TRUE.toString());
        }
        if (this.uploadToken != null) {
            hs.setRequestProperty("UPLOADTOKEN", this.uploadToken);
        }
        if (!scan) {
            hs.setRequestProperty("clearUploadStateOnCompletion", "true");
        }
        fis = new FileInputStream(f);
        if (segment > 0) {
            fis.skip(SEGMENT_SIZE * (long) segment);
        }

        int pos = 0;
        int chunk = CHUNK_SIZE;
        byte[] data = new byte[(int) length];
        byte[] buf = new byte[chunk];
        do {
            int len = fis.read(buf);
            System.arraycopy(buf, 0, data, pos, len);
            pos += len;
        } while ((long) pos < length);

        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        sha256.update(data);
        byte[] hash = sha256.digest();
        String strhash = getHexString(hash);
        hs.setRequestProperty("Hash256", strhash);

        long glength = length;
        if (scan) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gzipStream = new GZIPOutputStream(baos);
            gzipStream.write(data);
            gzipStream.close();
            glength = (long) baos.size();
            hs.setRequestProperty("Content-Encoding", "gzip");
            data = baos.toByteArray();
            baos.close();
        }
        hs.setRequestProperty("Content-Length", Long.toString(length));
        hs.connect();
        OutputStream sos = null;

        sos = hs.getOutputStream();
        sos.write(data, 0, (int) glength);
        dumpHttpResponse(hs);
        int code = hs.getResponseCode();


        if (code == 200) {
            in = new BufferedReader(new InputStreamReader(hs.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
                sb.append("\n");
            }

            if (result != null) {
                result = sb.toString();
            }
        }
    }catch (Exception e){

            System.out.println(e);

        }finally {
            if (in != null) {
                in.close();
            }

            if (fis != null) {
                fis.close();
            }

            if (hs != null) {
                hs.disconnect();
            }
        }

        return response;
    }

    public static void dumpHttpResponse(HttpURLConnection hs) throws Exception {
        try {
            int code = hs.getResponseCode();
            if (code == 412) {
                //logger.error("Version mismatch: Birst Connect is out of date with respect to the server.  Please log into the Birst Customer Support Portal at http://birst.custhelp.com to get a new version of Birst Connect.");
              //  exitApp(-100);
            }

            if (code == 200) {
                return;
            }

            if (code == 601) {
                throw new Exception("Space Unavailable: Space is involved in either swap, delete or copy operation.");
            }


        } catch (SocketTimeoutException var9) {

        }

    }
    public static String getHexString(byte[] b) {
        String result = "";

        for(int i = 0; i < b.length; ++i) {
            result = result + Integer.toString((b[i] & 255) + 256, 16).substring(1);
        }

        return result;
    }

    private HttpURLConnection setupConnection(String space, String filename, String phase) throws UnsupportedEncodingException, MalformedURLException, IOException, Exception {
        String path = "/" + URLEncoder.encode(space, "UTF-8").replace("+", "%20") + "/" + URLEncoder.encode(filename, "UTF-8").replace("+", "%20");
        HttpURLConnection hs = getHttpURLConnection(this.url, path, "POST", true, true);
        hs.setReadTimeout(240000);
        hs.setConnectTimeout(30000);
        hs.setRequestProperty("Version", "1");
        hs.setRequestProperty("Phase", phase);
        return hs;
    }

    public static HttpURLConnection getHttpURLConnection(String url, String path, String method, boolean ignoreSpaceInUseCheck, boolean explicitURL) throws MalformedURLException, IOException, Exception {
        URL urlObj = explicitURL ? new URL(url + path) : new URL(url + "/BirstConnect" + path);
        HttpsURLConnection.setDefaultHostnameVerifier(new NoOpHNVerifier());
        URLConnection s = urlObj.openConnection();

        HttpURLConnection hs = (HttpURLConnection)s;
        String allowInvalidCert = System.getProperty("jnlp.birst.disableCertificateCheckingInBirstConnectViaJNLP");
        String isAllowInvalidCertSetInBatchFile = System.getProperty("jnlp.birst.disableCertificateCheckingInBirstConnect");
        allowInvalidCert = isAllowInvalidCertSetInBatchFile == null || !isAllowInvalidCertSetInBatchFile.equalsIgnoreCase("false") && !isAllowInvalidCertSetInBatchFile.equalsIgnoreCase("true") ? allowInvalidCert : isAllowInvalidCertSetInBatchFile;
        if (hs instanceof HttpsURLConnection) {
            try {
                if (allowInvalidCert != null && allowInvalidCert.equalsIgnoreCase("true")) {
                    ((HttpsURLConnection)hs).setSSLSocketFactory(EncryptionService.getSSLSocketFactoryWithoutValidation());
                } else {
                    ((HttpsURLConnection)hs).setSSLSocketFactory(EncryptionService.getSSLSocketFactory());
                }
            } catch (Exception var11) {

            }
        }

        hs.setDoInput(true);
        hs.setDoOutput(true);
        hs.setUseCaches(false);
        hs.setRequestMethod(method);
        hs.setRequestProperty("User-Agent",  "Birst-WebDAV/2.0");
        hs.setRequestProperty("Host", new URL(url).getHost());
        hs.setRequestProperty("IgnoreSpaceInUseCheck", String.valueOf(ignoreSpaceInUseCheck));
        return hs;
    }
    private static class NoOpHNVerifier implements HostnameVerifier {
        private NoOpHNVerifier() {
        }

        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    }

    private class UploadThread extends Thread{
        boolean usesParallelUpload = false;
        int numSegments;
        String filename;
        File file;
        boolean scan;
        String result;
        public UploadThread(boolean usesParallelUpload, int threadNo, int numSegments, String filename, File file, boolean scan, String result) {
            super("UploadThread - " + threadNo);
            this.usesParallelUpload = usesParallelUpload;
            this.numSegments = numSegments;
            this.filename = filename;
            this.file = file;
            this.scan = scan;
            this.result = result;
        }

        public void run() {
            while (true){

            }
        }

    }
    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }
}
