package com.example.week6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import java.io.File
import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.widget.Button
import com.example.week6_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var downloadId: Long = -1L
    private lateinit var downloadManager: DownloadManager

    //브로드캐스트 리시버 선언
    private val onDownloadComplete = object : BroadcastReceiver() {
        //리시버 onReceive 구현
        override fun onReceive(context: Context, intent: Intent) {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            Log.d("id","$id")
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.action)) {
                if (downloadId == id) {
                    Log.d("hhhh","ggggg")
                    val query: DownloadManager.Query = DownloadManager.Query()
                    query.setFilterById(id)
                    var cursor = downloadManager.query(query)
                    if (!cursor.moveToFirst()) {
                        return
                    }

                    var columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)
                    var status = cursor.getInt(columnIndex)
                    if (status == DownloadManager.STATUS_SUCCESSFUL) {
                        Toast.makeText(context, "Download succeeded", Toast.LENGTH_SHORT).show()
                        Log.d("hi","hi")
                    } else if (status == DownloadManager.STATUS_FAILED) {
                        Toast.makeText(context, "Download failed", Toast.LENGTH_SHORT).show()
                        Log.d("hi","hiffff")
                    }
                }
            } else if (DownloadManager.ACTION_NOTIFICATION_CLICKED.equals(intent.action)) {
                Toast.makeText(context, "Notification clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //다운로드 매니저 객체
        downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        //인텐트 필터 선언
        //리시버와 인텐트 필터 연결
        val intentFilter = IntentFilter()
        intentFilter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        intentFilter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED)
        registerReceiver(onDownloadComplete,intentFilter, Context.RECEIVER_EXPORTED)



        binding.downloadBtn.setOnClickListener {
            val file = File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS + "/"), "newsletter.pdf")

            //다운받을 Url 주소
            val downloadUrl = "https://cse.pusan.ac.kr/sites/cse/download/201912_cse_newsletter_vol_29.pdf"
            val request = DownloadManager.Request(Uri.parse(downloadUrl))
                .setTitle("Downloading a file")
                .setDescription("Downloading CSE Newsletter")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setDestinationUri(Uri.fromFile(file))
                .setRequiresCharging(false)
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)

             //DownloadManager 객체 초기화
            //val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            downloadId = downloadManager.enqueue(request)
            Log.d("DownloadManager", "Download enqueued, downloadId: $downloadId")

        }

        binding.cancelBtn.setOnClickListener {
            if(downloadId!=-1L){
                downloadManager.remove(downloadId)
            }
        }
    }

    //리시버와 인텐트 필터 연결 해제
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(onDownloadComplete)
    }
}