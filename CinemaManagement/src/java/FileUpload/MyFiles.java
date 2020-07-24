/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUpload;

/**
 *
 * @author phamq
 */
public class MyFiles {

    //declare variable
    private long fileId;
    private String fileName;
    private String filePath;
    private String fileOriginalFilename;
    private String fileContentType;
    private long fileSize;
    private String fileDate;

    /**
     * get fileId method
     *
     * @return
     */
    public long getFileId() {
        return fileId;
    }

    /**
     * set fileId method
     *
     * @param fileId
     */
    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    /**
     * get file name method
     *
     * @return
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * set file name method
     *
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * get file path method
     *
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * set file path method
     *
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * get File Original Filename method
     *
     * @return
     */
    public String getFileOriginalFilename() {
        return fileOriginalFilename;
    }

    /**
     * set File Original Filename method
     *
     * @param fileOriginalFilename
     */
    public void setFileOriginalFilename(String fileOriginalFilename) {
        this.fileOriginalFilename = fileOriginalFilename;
    }

    /**
     * get File Content Type method
     *
     * @return
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * set File Content Type method
     *
     * @param fileContentType
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    /**
     * get File Size method
     *
     * @return
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * set File Size method
     *
     * @param fileSize
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * get File Date method
     *
     * @return
     */
    public String getFileDate() {
        return fileDate;
    }

    /**
     * set File Date method
     *
     * @param fileDate
     */
    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }
}
