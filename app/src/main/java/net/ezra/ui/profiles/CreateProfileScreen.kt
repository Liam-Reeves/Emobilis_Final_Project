package net.ezra.ui.profiles

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.add
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun CreateProfileScreen() {
    var name by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var age by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var bio by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var imageUrl by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var experie

    Column {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") })

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") })

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("Bio") })
        OutlinedTextField(
            value = imageUrl,
            onValueChange = { imageUrl = it },
            label = { Text("Image URL") })

        Button(onClick = {
            val newProfile = UserProfile(name, age.toInt(), bio, imageUrl.toString())
            UserProfilesState.profiles.add(newProfile)
        }) {
            Text(text = "Create Profile")
        }
    }
}