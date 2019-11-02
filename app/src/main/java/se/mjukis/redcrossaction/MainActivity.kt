package se.mjukis.redcrossaction

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var eventType = button.text.toString()

        val severityStatusPage = Intent(this, SeverityStatusActivity::class.java)
        button.setOnClickListener() {
            severityStatusPage.putExtra(IntentRelatedInfo.EVENT_TYPE.toString(), eventType)
            startActivity(severityStatusPage)
        }

    }
}
