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

            var reportInfo = JSONObject()
            reportInfo.put("type", intent.getStringExtra(EVENT_TYPE))
            reportInfo.put("severityLevel", resources.getResourceEntryName(severityLevelId))
            reportInfo.put("editionalInfo", comments.text.toString())

            reportIncidentUpdate(reportInfo)
        }
    }

    private fun reportIncidentUpdate(reportInfo: JSONObject?) {
        val queue = Volley.newRequestQueue(this)
        val url = "$BASE_URI/api/reportIncident"

        val stringRequest =  JsonObjectRequest(
            Request.Method.POST, url, reportInfo,

            Response.Listener<JSONObject> { response ->
                textView.text = "Response is: ${response}"
            },
            Response.ErrorListener { textView.text = "That didn't work!" })

        queue?.add(stringRequest)

        val requestSend = Toast.makeText(this, "Thank you, your request was sent", Toast.LENGTH_SHORT)
        requestSend.show()
    }
}
