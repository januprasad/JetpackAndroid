package com.jk.profile_layout // ktlint-disable package-name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jk.profile_layout.ui.theme.UdemyAppTheme
import com.jk.profile_layout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UdemyAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ProfileLayout()
    }
}

@Composable
fun ProfileLayout() {
    Card(
        modifier = Modifier
            .padding(16.dp)
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
            ProfilePicture()
            ProfileName()
        }
    }
}

@Composable
fun ProfileName() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp)
    ) {
        Text(text = "Manju Warrier", style = MaterialTheme.typography.h6)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = "Active", style = MaterialTheme.typography.body1)
        }
    }
}

@Composable
fun ProfilePicture() {
    Card(
        border = BorderStroke(
            1.dp,
            color = MaterialTheme.colors.lightGreen
        ),
        shape = CircleShape
    ) {
        Image(
            painterResource(R.drawable.img),
            "content description",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UdemyAppTheme {
        MainScreen()
    }
}
