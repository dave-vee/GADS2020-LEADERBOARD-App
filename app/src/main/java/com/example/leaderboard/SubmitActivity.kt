package com.example.leaderboard


import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.leaderboard.api.PostData
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)


        val name = findViewById<EditText>(R.id.First_Name)
        val lastName = findViewById<EditText>(R.id.Second_Name)
        val email = findViewById<EditText>(R.id.email_text)
        val link = findViewById<EditText>(R.id.link_text)
        val submitBtn = findViewById<Button>(R.id.button)





        submitBtn.setOnClickListener {

            if (isNetworkConnected()) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Are You Sure?")
                builder.setPositiveButton(R.string.yes) { _, _ ->
                    val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
                    coroutineScope.launch(errorHandler) {
                        name.text.toString()
                        lastName.text.toString()
                        email.text.toString()
                        link.text.toString()
                        val postData = PostData()
                        postData.post(name, lastName, email, link)

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