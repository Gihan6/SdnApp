package com.example.sdnapp.ui.login

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.FileProvider
import androidx.lifecycle.Observer
import com.example.sdnapp.BuildConfig
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.SessionTokenRequest
import com.example.sdnapp.db.Repo
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.dashboard.DashBoardActivity
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class LoginActivity : BaseActivity() {

    val RECORD_REQUEST_CODE=1001
    companion object {
        lateinit var loggedInUser: Repo
    }

    private val viewModel by inject<LoginViewModel>()
    private var llPdf: ConstraintLayout? = null

    // declaring variables
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"
    private var bitmap: Bitmap? = null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListenerForViewModel()
        llPdf = findViewById(R.id.parentMain)


        login()
        viewModel.getLoggedInUserFromLocal()



    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun login() {


        btn_login.setOnClickListener(View.OnClickListener {
            val permission = checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
//
//            if (permission == PackageManager.PERMISSION_GRANTED) {
//                Log.i("TAG", "Permission to record denied")
//                bitmap = loadBitmapFromView(llPdf!!, llPdf!!.width, llPdf!!.height)
//                createPdf()
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
//                        RECORD_REQUEST_CODE)
//            }

            if (!et_userName.text.toString().isNullOrEmpty()
                && !et_password.text.toString().isNullOrEmpty()
            ) {
                viewModel.getSessionTokenFromWebServices(
                    SessionTokenRequest(
                        et_userName.text.toString(),
                        et_password.text.toString(),
                        true
                    )
                )
            } else {
                Toast.makeText(this, "Compete data", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun initListenerForViewModel() {
        viewModel.getSessionToken().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        goToMain()
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()


                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }
            }
        })
        viewModel.getLoggedInUser().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (it.data != null) {
                            loggedInUser = it.data
                            goToMain()
                        }

                    }
                    Status.ERROR -> {
                        dismissLoading()
                        goToMain()
//                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                    }
                    Status.LOADING -> {
//                        showLoading()

                    }
                }
            }
        })

    }

    private fun goToMain() {
        var intent = Intent(this, DashBoardActivity::class.java)
        startActivity(intent)

    }

    private  fun loadBitmapFromView(v: View, width: Int, height: Int): Bitmap? {
        val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        v.draw(c)
        return b
    }
    @SuppressLint("ServiceCast")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun createPdf() {

        val displaymetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displaymetrics)
        val hight = displaymetrics.heightPixels.toFloat()
        val width = displaymetrics.widthPixels.toFloat()

        val convertHighet = hight.toInt()
        val convertWidth = width.toInt()


        val document = PdfDocument()
        val pageInfo = PageInfo.Builder(convertWidth, convertHighet, 1).create()
        val page = document.startPage(pageInfo)

        val canvas = page.canvas

        val paint = Paint()
        canvas.drawPaint(paint)

        bitmap = Bitmap.createScaledBitmap(bitmap!!, convertWidth, convertHighet, true)

        paint.color = Color.BLUE
        canvas.drawBitmap(bitmap!!, 0f, 0f, null)
        document.finishPage(page)


        val sdf = SimpleDateFormat("dd_M_yyyy_hh_mm_ss")
        val currentDate = sdf.format(Date())
//

        val targetPdf= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString().toString()+"/receipt"+currentDate+".pdf"

//        val targetPdf =
//                "/storage/emulated/o/Download/receipte$currentDate.pdf"
        val filePath: File
        filePath = File(targetPdf)
        try {
            document.writeTo(FileOutputStream(filePath))
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Something wrong: $e", Toast.LENGTH_LONG).show()
        }

        // close the document

        // close the document
        document.close()
//        Toast.makeText(this, "PDF is created!!!", Toast.LENGTH_SHORT).show()

        createNotification(filePath)
    }

    private fun createNotification(file: File) {
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

        var intent = Intent(Intent.ACTION_VIEW)
        val uri = FileProvider.getUriForFile(
                this,
                BuildConfig.APPLICATION_ID.toString() + ".provider",
                file
        )

        intent.setDataAndType(uri, "application/pdf")
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        intent.flags=Intent.FLAG_GRANT_READ_URI_PERMISSION


        val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        // checking if android version is greater than oreo(API 26) or not
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(
                    channelId,
                    description,
                    NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Ooredoo")
                    .setContentText("Download Documented")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)


        } else {

            builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Ooredoo")
                    .setContentText("Download Receipt")
                    .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234, builder.build())


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                when (requestCode) {
                    RECORD_REQUEST_CODE -> {

                        if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                            Log.i("TAG", "Permission has been denied by user")
                        } else {
                            Log.i("TAG", "Permission has been granted by user")
                        }
                    }
        }

    }

}