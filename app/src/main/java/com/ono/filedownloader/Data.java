package com.ono.filedownloader;

import android.net.Uri;
import android.os.Environment;

import com.tonyodev.fetch2.Request;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;


public final class Data {

    public static final String[] sampleUrls1 = new String[]{
            "http://speedtest.ftp.otenet.gr/files/test100Mb.db",
            "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_640x360.m4v",
            "http://media.mongodb.org/zips.json",
            "https://file-examples-com.github.io/uploads/2017/10/file-example_PDF_1MB.pdf",
            "https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_5MG.mp3",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"};


    public static final String[] sampleUrls = new String[]{
            "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_1920_18MG.mp4",
            "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_1280_10MG.mp4",
            "https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_5MG.mp3",
            "https://file-examples-com.github.io/uploads/2017/10/file-example_PDF_1MB.pdf",
            "http://media.mongodb.org/zips.json",
            "https://file-examples-com.github.io/uploads/2020/03/file_example_WEBM_1920_3_7MB.webm"};

    private Data() {

    }

    @NonNull
    private static List<Request> getFetchRequests() {
        final List<Request> requests = new ArrayList<>();
        for (String sampleUrl : sampleUrls) {
            final Request request = new Request(sampleUrl, getFilePath(sampleUrl));
            requests.add(request);
        }
        return requests;
    }

    @NonNull
    private static String getFilePath(@NonNull final String url) {
        final Uri uri = Uri.parse(url);
        final String fileName = uri.getLastPathSegment();
        final String dir = getSaveDir();
        return (dir + "/DownloadList/" + fileName);
    }

    @NonNull
    public static List<Request> getFetchRequestWithGroupId(final int groupId) {
        final List<Request> requests = getFetchRequests();
        for (Request request : requests) {
            request.setGroupId(groupId);
        }
        return requests;
    }

    @NonNull
    public static String getSaveDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/fetch";
    }

}
