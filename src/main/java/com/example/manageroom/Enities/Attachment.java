package com.example.manageroom.Enities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Attachment {
    @Id
    private Integer attachment_id;
    private Date upload_at;
    private String file_url;

    public Attachment() {
    }

    public Attachment(Integer attachment_id, Date upload_at, String file_url) {
        this.attachment_id = attachment_id;
        this.upload_at = upload_at;
        this.file_url = file_url;
    }

    public Integer getAttachment_id() {
        return attachment_id;
    }

    public void setAttachment_id(Integer attachment_id) {
        this.attachment_id = attachment_id;
    }


    public Date getUpload_at() {
        return upload_at;
    }

    public void setUpload_at(Date upload_at) {
        this.upload_at = upload_at;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachment_id=" + attachment_id +
                ", upload_at=" + upload_at +
                ", file_url='" + file_url + '\'' +
                '}';
    }
}
