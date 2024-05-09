package net.ezra.ui.profiles

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


@Composable
fun ProfileList() {
    Column {
        UserProfilesState.profiles.forEach { profile ->
            ProfileCard(profile)
        }
    }
}