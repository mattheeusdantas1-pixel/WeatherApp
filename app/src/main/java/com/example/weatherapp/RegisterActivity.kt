package com.example.weatherapp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    val activity = LocalActivity.current as Activity

    val fieldModifier = Modifier.fillMaxWidth(fraction = 0.9f)

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crie sua conta",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = name,
            label = { Text(text = "Nome") },
            modifier = fieldModifier,
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.size(12.dp))
        OutlinedTextField(
            value = email,
            label = { Text(text = "E-mail") },
            modifier = fieldModifier,
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.size(12.dp))
        OutlinedTextField(
            value = password,
            label = { Text(text = "Senha") },
            modifier = fieldModifier,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.size(12.dp))
        OutlinedTextField(
            value = confirmPassword,
            label = { Text(text = "Confirmar Senha") },
            modifier = fieldModifier,
            onValueChange = { confirmPassword = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.size(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    Firebase.auth.createUserWithEmailAndPassword(email.trim(), password)
                        .addOnCompleteListener(activity) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(activity, "Registro OK!", Toast.LENGTH_LONG).show()
                                activity.finish()
                            } else {
                                Toast.makeText(activity, "Registro FALHOU!", Toast.LENGTH_LONG).show()
                            }
                        }
                },
                enabled = name.isNotEmpty() && email.isNotEmpty() && 
                          password.isNotEmpty() && confirmPassword.isNotEmpty() &&
                          password == confirmPassword
            ) {
                Text("Confirmar")
            }
            Button(
                onClick = { 
                    name = ""; email = ""; password = ""; confirmPassword = "" 
                }
            ) {
                Text("Limpar")
            }
        }
    }
}
