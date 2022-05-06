package com.example.cloudmusic.entity;

public class LoveList {
    private String uuid;
    private String coverImgUrl;
    private String avatarUrl;
    private String nickname;
    private Long createTime;
    private Integer subscribedCount;
    private Integer shareCount;
    private Integer trackCount;
    private Integer playCount;

    public LoveList(String uuid, String coverImgUrl, String avatarUrl,
                    String nickname, Long createTime, Integer subscribedCount,
                    Integer shareCount, Integer trackCount, Integer playCount) {
        this.uuid = uuid;
        this.coverImgUrl = coverImgUrl;
        this.avatarUrl = avatarUrl;
        this.nickname = nickname;
        this.createTime = createTime;
        this.subscribedCount = subscribedCount;
        this.shareCount = shareCount;
        this.trackCount = trackCount;
        this.playCount = playCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(Integer subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }
}
