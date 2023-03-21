package com.example.boxes.loginfeature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.boxes.R
import com.example.boxes.main.presentation.Screen

@Composable
fun LoginScreen(navController: NavController,
                loginViewModel: LoginViewModel = hiltViewModel(),
                onNavigate: (Screen)->Unit
) {
    val lState = loginViewModel.state.collectAsStateWithLifecycle()
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {
        OutlinedTextField(
            value =lState.value.mail,
            onValueChange =loginViewModel::onMailChanged,
            label = {Text(text = "Email")})
        OutlinedTextField(
            value =lState.value.password,
            onValueChange =loginViewModel::onPasswordChanged,
            label = {Text(text = "Password")})
        OutlinedTextField(
            value =lState.value.repeatedPassword,
            onValueChange =loginViewModel::onRepeatedPasswordChanged,
            label = {Text(text = "Repeat password")})

        Button(onClick =  loginViewModel::onLogin
        ) {
            Text(text = stringResource(R.string.Login))
        }

        Button(onClick = loginViewModel::onRegister

        ) {
            Text(text = stringResource(R.string.Register))
        }
    }
}
// {  onNavigate(Screen.BoxesScreen)
//                navController.navigate(Screen.BoxesScreen.withArgs("atAta"))}

