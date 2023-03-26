package com.example.boxes.loginfeature.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.boxes.main.presentation.Screen


@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    LaunchedEffect(context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is LoginViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "Login successful",
                        Toast.LENGTH_LONG
                    ).show()
                    val x = state.value.id.toString()
                    navController.navigate(Screen.BoxesScreen.route
                            + "/${x}")
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.value.email,
            onValueChange = {
                viewModel.onEvent(LoginEvent.EmailChanged(it))
            },
            isError = state.value.emailError != "",
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        if (state.value.emailError != "") {
            Text(
                text = state.value.emailError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.value.password,
            onValueChange = {
                viewModel.onEvent(LoginEvent.PasswordChanged(it))
            },
            isError = state.value.passwordError != "",
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        if (state.value.passwordError != "") {
            Text(
                text = state.value.passwordError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.onEvent(LoginEvent.Submit)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Submit")
        }

        Row(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            Arrangement.End,
            Alignment.Bottom
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.RegisterScreen.route)
                }
            ) {
                Text(text = "To registration")
            }
        }
    }
}

