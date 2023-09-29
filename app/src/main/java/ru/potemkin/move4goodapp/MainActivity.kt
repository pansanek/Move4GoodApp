package ru.potemkin.move4goodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.potemkin.move4goodapp.data.ActivityRepositoryImpl
import ru.potemkin.move4goodapp.databinding.ActivityMainBinding
import ru.potemkin.move4goodapp.presentation.ActivityListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var activityListAdapter: ActivityListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Log.d("ADPTR","1")
        setContentView(binding.root)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.activityList.observe(this) {activityList ->
            activityListAdapter.submitList(activityList)
            activityListAdapter.notifyDataSetChanged()
        }
        setupOnClick()
    }

    private fun setupOnClick() {
        with(binding) {
            icLeaderboard.setOnClickListener {
                val intent = LeaderboardActivity.newIntent(this@MainActivity)
                startActivity(intent)
                finish()
            }
            icProfile.setOnClickListener {
                val intent = ProfileActivity.newIntent(this@MainActivity)
                startActivity(intent)
                finish()
            }
        }
    }


    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvActivityList.layoutManager = layoutManager
        activityListAdapter = ActivityListAdapter()
        binding.rvActivityList.adapter = activityListAdapter
        setupLongClickListener()
    }
    private fun setupLongClickListener() {
        activityListAdapter.onActivityItemLongClickListener = {
            Toast.makeText(
                this@MainActivity,
                it.name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

}