package com.example.leaderboard


import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.leaderboard.api.PostData
import kotlinx.android.synthetic.main.activity_submit.*
import kotlinx.coroutines.*


class SubmitActivity : AppCompatActivity() {

    val mainActivityJob = Job()

    //2 Handle exceptions if any
    val errorHandler = CoroutineExceptionHandler { _, exception ->
        AlertDialog.Builder(this).setTitle("Error")
            .setMessage(exception.message)
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()

    }
    val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
    val postData = PostData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)


        val name = findViewById<EditText>(R.id.First_Name)
        val lastName = findViewById<EditText>(R.id.Second_Name)
        val email = findViewById<EditText>(R.id.email_text)
        val link = findViewById<EditText>(R.id.link_text)






        button.setOnClickListener {

            if (isNetworkConnected()) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Are You Sure?")
                builder.setPositiveButton(R.string.yes) { _, _ ->
                    coroutineScope.launch(errorHandler) {
                        postData.post(
                            name.toString(),
                            lastName.toString(),
                            email.toString(),
                            link.toString()
                        )

                    }
                }.show()


            } else {
                AlertDialog.Builder(this).setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again")
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()
            }
        }


    }

    private fun isNetworkConnected(): Boolean {

        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}