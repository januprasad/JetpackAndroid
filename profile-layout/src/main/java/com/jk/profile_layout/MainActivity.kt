package com.jk.profile_layout // ktlint-disable package-name

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.jk.profile_layout.ui.theme.UdemyAppTheme
import com.jk.profile_layout.ui.theme.lightGreen
import com.jk.profile_layout.ui.theme.lightRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UdemyAppTheme {
                UserProfileList()
            }
        }
    }
}

@Composable
fun UserProfileList() {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(userProfiles) { profile ->
                    ProfileLayout(profile)
                }
            }
        }
    }
}

@Composable
fun UserProfileDetail(userProfile: UserProfile = userProfiles[0]) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicture(userProfile.icon, userProfile.status, 200.dp)
                ProfileName(
                    userProfile.name,
                    userProfile.status,
                    alignment = Alignment.CenterHorizontally
                )
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Chatter",
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Icon"
                )
            }
        },
        elevation = 12.dp
    )
}

@Composable
fun ProfileLayout(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(8.dp, 8.dp, 8.dp, 4.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Top),
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfilePicture(userProfile.icon, userProfile.status, 72.dp)
            ProfileName(userProfile.name, userProfile.status)
        }
    }
}

@Composable
fun ProfileName(
    name: String,
    status: Boolean,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = alignment
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides
                if (status) {
                    1f
                } else ContentAlpha.medium
        ) {
            Text(text = name, style = MaterialTheme.typography.h6)
        }
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text =
                if (status) {
                    "Active"
                } else "Offline",
                style = MaterialTheme.typography.body1,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun ProfilePicture(profileImage: String, status: Boolean, imageSize: Dp) {
    Card(
        border = BorderStroke(
            2.dp,
            color =
            if (status) {
                MaterialTheme.colors.lightGreen
            } else MaterialTheme.colors.lightRed
        ),
        shape = CircleShape
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = profileImage)
                    .apply(block = fun ImageRequest.Builder.() {
                        transformations(CircleCropTransformation())
                    }).build()
            ),
            modifier = Modifier.size(imageSize),
            contentDescription = "Profile picture"
        )
    }
}

private fun mToast(context: Context) {
    Toast.makeText(context, "This is a Sample Toast", Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true)
@Composable
fun UserProfileListPreview() {
    UdemyAppTheme {
        UserProfileList()
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailPreview() {
    UdemyAppTheme {
        UserProfileDetail()
    }
}
