package se.mjukis.redcrossaction

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Response
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //from: https://developer.android.com/training/volley/simple.html#kotlin
            val queue = Volley.newRequestQueue(this)
            val url = "http://www.google.com"

            // Request a string response from the provided URL.
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textView.text = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener { textView.text = "That didn't work!" })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)


        }
    }
}
