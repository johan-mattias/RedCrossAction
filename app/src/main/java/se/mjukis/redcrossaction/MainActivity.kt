package se.mjukis.redcrossaction

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun chooseEvent(view: View?){
        val severityStatusPage = Intent(this, SeverityStatusActivity::class.java)
        var eventType = (view as Button).text.toString()
            severityStatusPage.putExtra(IntentRelatedInfo.EVENT_TYPE.toString(), eventType)
            startActivity(severityStatusPage)

    }
}
