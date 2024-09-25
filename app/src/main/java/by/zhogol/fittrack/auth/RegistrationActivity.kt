package by.zhogol.fittrack.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.zhogol.fittrack.R
import by.zhogol.fittrack.profile.ProfileActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var labelTextView: TextView
    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var passwordRepeatEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initializeViews()

        setupListeners()
    }

    private fun initializeViews() {
        nameEditText = findViewById(R.id.nameEnter)
        passwordEditText = findViewById(R.id.passwordEnter)
        passwordRepeatEditText = findViewById(R.id.passwordRepeat)
        loginButton = findViewById(R.id.loginButton)
        signUpButton = findViewById(R.id.signupButton)
        labelTextView = findViewById(R.id.registration)
    }

    private fun setupListeners() {
        signUpButton.setOnClickListener {
            if (validateRegistrationData()) {
                // Если учетные данные валидны, переходим на страницу профиля
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        loginButton.setOnClickListener {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateRegistrationData(): Boolean {
        val name = nameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val passwordRepeat = passwordRepeatEditText.text.toString().trim()

        return when {
            name.isEmpty() -> {
                showErrorMessage("Пожалуйста, введите имя")
                false
            }

            password.isEmpty() -> {
                showErrorMessage("Пожалуйста, введите пароль")
                false
            }

            password != passwordRepeat -> {
                showErrorMessage("Пароли не совпадают")
                false
            }

            else -> {
                // Здесь должна быть логика регистрации
                // Например, запрос к серверу или сохранение в локальном хранилище
                // Для простоты примера мы просто завершаем активность
                finish()
                true
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
