package cn.ahpu.other;

import java.awt.print.Book;

public class 序列化 {
    public static void main(String[] args) {

    }
}

/*
class User implements Parcelable {
    public int userID;
    public String userName;
    public boolean isMale;

    public Book book;


    public User (int userID, String userName, boolean isMale) {
        this.userID= userID;
        this.userName= userName;
        this.isMale= isMale;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userID);
        dest.writeString(this.userName);
        dest.writeInt(isMale ? 1 : 0);
        dest.writeParcelable(book, 0);
    }

    protected User(Parcel in) {
        this.userID= in.readInt();
        this.userName= in.readString();
        this.isMale= in.readInt() == 1;
        this.book= in.readParcelable(Thread.currentThread().getContextClassLoader());
    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

}*/