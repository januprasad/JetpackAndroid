package com.jk.udemyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier
            .fillMaxSize()

    ) {
        TheAwesomeColumn()
        Surface(
            color = Color.Gray,
            modifier = Modifier
                .wrapContentSize(align = Alignment.TopCenter)
                .fillMaxWidth()
                .height(60.dp)

        ) {
            Text(
                text = "Components",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun TheAwesomeColumn() {
    Column(
        modifier = Modifier.padding(40.dp, 80.dp, 40.dp, 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image()

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.wrapContentSize()) {
            RoundedCornerColorBox(Color.Red)
            Spacer(modifier = Modifier.width(16.dp))
            RoundedCornerColorBox(Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        RoundedCornerColorBox(Color.Green)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
