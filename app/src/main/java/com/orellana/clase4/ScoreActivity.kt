package com.orellana.clase4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ScoreActivity : AppCompatActivity() {
    private lateinit var score_A: TextView
    private lateinit var score_B : TextView
    private lateinit var status_A: TextView
    private lateinit var status_B: TextView
    private var scoreA = 0
    private var scoreB = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        bind()
        intent?.let { intent -> //si intent es diferente de nullo
            scoreA= intent.getIntExtra(MainActivity.KEY_SCORE_TEAM_A, 0)
            scoreB= intent.getIntExtra(MainActivity.KEY_SCORE_TEAM_B, 0)
        }
        marcador()
    }

fun bind (){
    score_A = findViewById(R.id.teamA_count)
    score_B = findViewById(R.id.teamB_count)
    status_A = findViewById(R.id.status_winner_A)
    status_B = findViewById(R.id.status_winner_B)
}
    fun marcador (){
        score_A.text = scoreA.toString()
        score_B.text = scoreB.toString()
        if (scoreA == scoreB){
            status_B.text = getString(R.string.winner)
        }
    }
}