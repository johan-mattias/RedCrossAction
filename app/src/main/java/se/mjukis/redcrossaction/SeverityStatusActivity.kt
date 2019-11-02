package se.mjukis.redcrossaction

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_severity_status.*
import org.json.JSONObject


class SeverityStatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_severity_status)

        reportBtn.setOnClickListener {
            val severityLevelId = severityLevelRadioGroup.checkedRadioButtonId
            val severityValue = resources.getResourceEntryName(severityLevelId)

            val editionalInfo = comments.text.toString()

            reportIncidentUpdate()
        }
    }

    private fun reportIncidentUpdate() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://www.google.com"

        val stringRequest =  JsonObjectRequest(
            Request.Method.GET, url, null,

            Response.Listener<JSONObject> { response ->
                textView.text = "Response is: ${response.getString("test")}"
            },
            Response.ErrorListener { textView.text = "That didn't work!" })

        queue.add(stringRequest)

        val requestSend = Toast.makeText(this, "Thank you, your request was sent", Toast.LENGTH_SHORT)
        requestSend.show()
    }
}
