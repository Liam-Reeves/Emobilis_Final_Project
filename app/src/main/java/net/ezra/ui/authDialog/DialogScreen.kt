package net.ezra.ui.authDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//sealed class RegistrationState {
//    object Idle : RegistrationState()
//    object Loading : RegistrationState()
//    object Success : RegistrationState()
//    data class Error(val message: String) : RegistrationState()
//}

@Composable
fun DialogScreen(navController:NavHostController) {


//
//    class RegistrationViewModel(val registrationUseCase: RegistrationUseCase) : ViewModel() {
//        private val _state = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
//        val state = _state.asStateFlow()
//
//        fun register(username: String, password: String) {
//            viewModelScope.launch {
//                _state.value = RegistrationState.Loading
//                try {
//                    registrationUseCase.register(username, password)
//                    _state.value = RegistrationState.Success
//                } catch (e: Exception) {
//                    _state.value = RegistrationState.Error(e.localizedMessage ?: "Registration failed")
//                }
//            }
//        }
//    }
//
//
//    @Composable
//    fun RegisterScreen(viewModel: RegistrationViewModel, navigateToHome: () -> Unit) {
//        val state = viewModel.state.collectAsState()
//
//        var username by remember {
//            mutableStateOf(TextFieldValue(""))
//        }
//
//
//
//
//        var password by remember {
//            mutableStateOf(TextFieldValue(""))
//        }
//
//        Box(modifier = Modifier.fillMaxSize()) {
//            when (val registrationState = state.value) {
//                RegistrationState.Idle -> {
//                    // Registration form UI
//                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
//                        TextField(
//                            value = username,
//                            onValueChange = { username = it },
//                            label = { Text("Username") }
//                        )
//                        Spacer(modifier = Modifier.height(16.dp))
//                        TextField(
//                            value = password,
//                            onValueChange = { password = it },
//                            label = { Text("Password") },
//                            isPasswordVisibilityToggleEnabled = true
//                        )
//                        Spacer(modifier = Modifier.height(16.dp))
//                        Button(onClick = { viewModel.register(username, password) }) {
//                            Text("Register")
//                        }
//                    }
//                }
//                RegistrationState.Loading -> {
//                    // Show a progress indicator
//                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                }
//                RegistrationState.Success -> {
//                    // Success message and maybe a button to navigate
//                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
//                        Text(text = "You successfully created your Yaya Account!", style = MaterialTheme.typography.h6)
//                        Spacer(modifier = Modifier.height(16.dp))
//                        Button(onClick = navigateToHome) {
//                            Text("Go to Home")
//                        }
//                    }
//                }
//                is RegistrationState.Error -> {
//                    // Show an error message
//                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
//                        Text(text = "Registration failed: ${registrationState.message}", color = MaterialTheme.colors.error)
//                        Spacer(modifier = Modifier.height(16.dp))
//                        Button(onClick = { viewModel.register(username, password) }) {
//                            Text("Retry")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//}
}

@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    DialogScreen(rememberNavController())
}