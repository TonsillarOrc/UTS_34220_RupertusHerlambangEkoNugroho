package id.ac.umn.uts_;

import android.net.Uri;

import java.io.Serializable;

public class SumberVideo implements Serializable {
    private String judul, keterangan, videoURI;
    public SumberVideo(String judul, String keterangan, String videoURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.videoURI = videoURI;
    }
    public String getJudul(){
        return this.judul;
    }
    public String getKeterangan(){
        return this.keterangan;
    }
    public Uri getVideoURI(){
        return Uri.parse(this.videoURI);
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }
    public void setSoundURI(String videoURI){
        this.videoURI = videoURI;
    }
    public String toString(){
        return this.getJudul() + " => " + this.getKeterangan();
    }
}
