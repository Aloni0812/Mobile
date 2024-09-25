package by.zhogol.fittrack.profile

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.zhogol.fittrack.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var btnAddTraining: Button
    private lateinit var btnEditProfile: Button
    private lateinit var rvTrainingsList: RecyclerView
    private lateinit var tvUserName: TextView
    private lateinit var tvCurrentWeight: TextView
    private lateinit var tvCurrentHeight: TextView
    private lateinit var tvTrainingsListTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initializeViews()
        setupListeners()
    }

    private fun initializeViews() {
        btnAddTraining = findViewById(R.id.btn_add_training)
        btnEditProfile = findViewById(R.id.btn_edit_profile)
        rvTrainingsList = findViewById(R.id.rv_trainings_list)
        tvUserName = findViewById(R.id.tv_user_name)
        tvCurrentWeight = findViewById(R.id.tv_current_weight)
        tvCurrentHeight = findViewById(R.id.tv_current_height)
        tvTrainingsListTitle = findViewById(R.id.tv_trainings_list_title)
    }

    private fun setupListeners() {
        btnAddTraining.setOnClickListener {
            // Здесь можно добавить логику для добавления тренировки
            println("Добавить тренировку")
        }

        btnEditProfile.setOnClickListener {
            // Здесь можно добавить логику для редактирования профиля
            println("Изменить профиль")
        }

        // Здесь можно добавить логику для обработки событий RecyclerView
    }
}
