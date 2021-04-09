package com.example.notes_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Date;

public class NotesInfo implements Parcelable {
    private String name, description;
    private Date dateOfCreate;

    public NotesInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected NotesInfo(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NotesInfo> CREATOR = new Creator<NotesInfo>() {
        @Override
        public NotesInfo createFromParcel(Parcel in) {
            return new NotesInfo(in);
        }

        @Override
        public NotesInfo[] newArray(int size) {
            return new NotesInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
}
