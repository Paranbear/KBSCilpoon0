package com.android.kusitms.kbscilpoon.Chatbot.Model;

public class Chat {
    private String user_no, room_no;// 메시지내에서 내 고유번호, 방 고유번호
    private String message, action;//메시지 내용, 메시지 종류
    private boolean is_me; //본인이 보낸 메시지인지 확인
    private String date;
    private String timestamp;

    public Chat(String user_no, String room_no,String timestamp,String message, boolean is_me, String action ) {
        this.user_no = user_no;
        this.room_no = room_no;
        this.message = message;
        this.timestamp=timestamp;
        this.is_me = is_me;
        this.action = action;
    }
    //서버에 보낼 메시지 구조체 추후 생성(user_no, room_no
    public Chat(String user_no, String room_no ) {
        this.user_no = user_no;
        this.room_no = room_no;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_no() {
        return user_no;
    }

    public String getRoom_no() {
        return room_no;
    }

    public String getMessage() {
        return message;
    }

    public String getAction() {
        return action;
    }

    public boolean isIs_me() {
        return is_me;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setIs_me(boolean is_me) {
        this.is_me = is_me;
    }
}
