package se.mjukis.redcrossaction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun chooseEvent(view: View){
        val severityStatusPage = Intent(this, SeverityStatusActivity::class.java)
        var eventType = view.context.resources.getResourceEntryName(view.id)
            severityStatusPage.putExtra(EVENT_TYPE, eventType)
            startActivity(severityStatusPage)

    }
}
