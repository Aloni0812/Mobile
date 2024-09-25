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

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var labelTextView: TextView
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var logInButton: Button
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        initializeViews()

        setupListeners()
    }

    private fun initializeViews() {
        labelTextView = findViewById(R.id.label)
        loginEditText = findViewById(R.id.nameEnter)
        passwordEditText = findViewById(R.id.passwordEnter)
        logInButton = findViewById(R.id.logInButton)
        signUpButton = findViewById(R.id.signupButton)
    }

    private fun setupListeners() {
        logInButton.setOnClickListener {
            if (validateCredentials()) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun validateCredentials(): Boolean {
        val username = loginEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        return when {
            username.isEmpty() -> {
                showErrorMessage("Пожалуйста, введите логин")
                false
            }
            !isValidUsername(username) -> {
                showErrorMessage("Логин должен состоять из 8 цифр")
                false
            }
            password.isEmpty() -> {
                showErrorMessage("Пожалуйста, введите пароль")
                false
            }
            !isValidPassword(password) -> {
                showErrorMessage("Пароль должен содержать не менее 8 символов")
                false
            }
            else -> {
                // Проверка успешна
                // Здесь можно добавить логику аутентификации
                performAuthentication(username, password)
                true
            }
        }
    }

    private fun isValidUsername(username: String): Boolean {
        return username.length == 8 && username.all { it.isDigit() }
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideErrorMessage() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
    }

    private fun performAuthentication(username: String, password: String) {
        // Здесь должна быть реальная логика аутентификации
        // Например, запрос к серверу или проверка в локальном хранилище
        // Для простоты примера мы просто выводим сообщение о успехе
        Toast.makeText(this, "Аутентификация успешна", Toast.LENGTH_SHORT).show()

        // После успешной аутентификации можно перейти на следующую активность
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}

