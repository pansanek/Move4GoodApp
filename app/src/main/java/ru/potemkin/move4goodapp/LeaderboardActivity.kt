package ru.potemkin.move4goodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.potemkin.move4goodapp.databinding.ActivityLeaderboardBinding

class LeaderboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLeaderboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupOnClick()
    }


    private fun setupOnClick() {
        with(binding) {
            icGoals.setOnClickListener {
                val intent = MainActivity.newIntent(this@LeaderboardActivity)
                startActivity(intent)
                finish()
            }
            icProfile.setOnClickListener {
                val intent = ProfileActivity.newIntent(this@LeaderboardActivity)
                startActivity(intent)
                finish()
            }
        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LeaderboardActivity::class.java)
            return intent
        }
    }
}