package com.maiziyun.boss.web.vo;

/**
 * Created by admin on 2017/7/3.
 */
public class UpdateNoticeRequestVo extends BaseRequest {
    private String announcementId;
    private String title;
    private String typeId;
    private String content;
    private String qudaoId;
    private String stateId;
    private String startTime;
    private String endTime;

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQudaoId() {
        return qudaoId;
    }

    public void setQudaoId(String qudaoId) {
        this.qudaoId = qudaoId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
