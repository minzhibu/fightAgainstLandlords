package com.sjm.PlayingCards.dto;

/**
 * 游客信息
 */
public class TouristInformation {
    private String id;
    private String name;
    private String chip;
    private String roomId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "TouristInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chip='" + chip + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
