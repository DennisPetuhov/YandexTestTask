//package com.example.yandextesttask.service
//
//import android.app.Service
//import android.content.Intent
//import android.os.IBinder
//import com.example.yandextesttask.ui.MainScreenViewModel
//import org.koin.androidx.viewmodel.ext.android.viewModel
//
//
//class MyService : Service() {
//    private val viewModel: MainScreenViewModel by viewModel()
//    override fun onBind(intent: Intent?): IBinder? {
//        // Return null because this is a started service, not a bound service
//        return null
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        // Initialize your service here
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        viewModel.updetaDataFromService("Service message")
//        // Perform your service task here
//        // Return START_STICKY if you want the service to remain running until explicitly stopped
//        return START_STICKY
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        // Clean up any resources here
//    }
//}