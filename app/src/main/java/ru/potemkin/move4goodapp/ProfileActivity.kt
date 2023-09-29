package ru.potemkin.move4goodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.potemkin.move4goodapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupOnClick()
    }


    private fun setupOnClick() {
        with(binding) {
            icGoals.setOnClickListener {
                val intent = MainActivity.newIntent(this@ProfileActivity)
                startActivity(intent)
                finish()
            }
            icLeaderboard.setOnClickListener {
                val intent =LeaderboardActivity.newIntent(this@ProfileActivity)
                startActivity(intent)
                finish()
            }
        }
    }


    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }
}