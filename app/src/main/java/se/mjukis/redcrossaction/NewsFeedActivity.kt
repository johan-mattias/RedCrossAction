package se.mjukis.redcrossaction

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_news_feed.*
import org.json.JSONArray
import org.json.JSONObject


class NewsFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)
        getNews()
    }

    fun updateNewsStatus(view: View) {
        val eventTypePage = Intent(this, MainActivity::class.java)
        startActivity(eventTypePage)
    }

    fun getNews() {
        val url = "$BASE_URI/api/news"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val news = response
                    .getJSONArray("news")

                news_list.adapter =  NewsAdapter(news)
            },
            Response.ErrorListener { error: VolleyError ->
                Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
            })
        request.retryPolicy = DefaultRetryPolicy(10000, 5, 1f)
        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }

    class NewsAdapter(val news: JSONArray) : RecyclerView.Adapter<NewsViewHolder>() {
        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            holder.bind(news.getJSONObject(position), position)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.news_item, parent, false)

            return NewsViewHolder(view)
        }

        override fun getItemCount(): Int = news.length()
    }

    class NewsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(newsItem: JSONObject, position: Int) {
            val title = view.findViewById(R.id.newsTitle) as TextView
            title.text = newsItem["text"].toString()
            val checkBox = view.findViewById(R.id.newsStatusCheckBox) as CheckBox
            checkBox.isChecked = true
        }
    }
}
