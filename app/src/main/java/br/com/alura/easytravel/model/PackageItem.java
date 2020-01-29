package br.com.alura.easytravel.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class PackageItem implements Parcelable {

    private final String image;
    private final String destination;
    private final int stay;
    private final BigDecimal price;

    public PackageItem(String image, String destination, int stay, BigDecimal price) {
        this.image = image;
        this.destination = destination;
        this.stay = stay;
        this.price = price;
    }

    // Parcelable implementation:
    protected PackageItem(Parcel in) {
        this.image = in.readString();
        this.destination = in.readString();
        this.stay = in.readInt();
        this.price = BigDecimal.valueOf(in.readDouble());
    }

    public static final Creator<PackageItem> CREATOR = new Creator<PackageItem>() {
        @Override
        public PackageItem createFromParcel(Parcel in) {
            return new PackageItem(in);
        }

        @Override
        public PackageItem[] newArray(int size) {
            return new PackageItem[size];
        }
    };

    public String getDestination() {
        return destination;
    }

    public String getImage() {
        return image;
    }

    public int getStay() {
        return stay;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int index) {
        parcel.writeString(this.image);
        parcel.writeString(this.destination);
        parcel.writeInt(this.stay);
        parcel.writeDouble(this.price.doubleValue());
    }
}
