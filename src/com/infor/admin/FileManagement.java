package com.infor.admin;


public class FileManagement extends AbstractManagement {

    public String  beginDataUpload(String token, String spaceId, String fileName){
        return this.getClient().beginDataUpload(token,spaceId,fileName);
    }

    public void uploadData(String token, String uploadToken, int numBytes, byte[] data){
        this.getClient().uploadData(token,uploadToken,numBytes,data);
    }

    public void finishDataUpload(String token, String dataUploadToken){
        getClient().finishDataUpload(token,dataUploadToken);
    }

    public Boolean isDataUploadComplete(String token, String uploadToken){
        return getClient().isDataUploadComplete(token,uploadToken);
    }

}
