package com.ono.filedownloader;

public interface ActionListener {

    void onPauseDownload(int id);

    void onResumeDownload(int id);

    void onRetryDownload(int id);
}
