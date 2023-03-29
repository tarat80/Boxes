package com.example.boxes.registerfeature.presentation

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
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is RegisterViewModel.ValidationEvent.Success -> {
                    Toast.makeText(
                        context,
                        "Registration successful",
                        Toast.LENGTH_LONG
                    ).show()
                    val id = state.value.id
                    navController.navigate(
                        Screen.BoxesScreen.route + "/${id}"
                    )
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
                viewModel.onEvent(RegisterEvent.EmailChanged(it))
            },
            isError = state.value.emailError.isNotBlank(),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Text(
            text = state.value.emailError,
            color = MaterialTheme.colors.error,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.value.password,
            onValueChange = {
                viewModel.onEvent(RegisterEvent.PasswordChanged(it))
            },
            isError = state.value.passwordError.isNotBlank(),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            text = state.value.passwordError,
            color = MaterialTheme.colors.error,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.value.repeatedPassword,
            onValueChange = {
                viewModel.onEvent(RegisterEvent.RepeatedPasswordChanged(it))
            },
            isError = state.value.repeatedPasswordError.isNotBlank(),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Repeat password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            text = state.value.repeatedPasswordError,
            color = MaterialTheme.colors.error,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = state.value.acceptedTerms,
                onCheckedChange = {
                    viewModel.onEvent(RegisterEvent.AcceptTerms(it))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Accept terms")
        }

        Text(
            text = state.value.termsError,
            color = MaterialTheme.colors.error,
        )

        Button(
            onClick = {
                viewModel.onEvent(RegisterEvent.Submit)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Submit")
        }
        Text(
            text = state.value.idError,
            color = MaterialTheme.colors.error,
            modifier = Modifier.align(Alignment.End)
        )
    }
}

