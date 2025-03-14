package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.EducationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                DefaultPreivew()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreivew() {
    val geners = listOf<String>(
        "Brainstorm", "Videos", "Books", "Others"
    )

    EducationAppTheme {
        Scaffold() {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(it)
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 25.dp),
                    text = buildAnnotatedString {
                        append("Choose What \n \n ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.DarkGray
                            )
                        ) {
                            append("To Learn Today?")
                        }
                    })
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    items(geners) { genre -> Genre(genre) }
                }

                Box(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clip(RoundedCornerShape(10))
                        .background(colorResource(id = R.color.mainColor))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 30.dp)
                                .padding(start = 20.dp)
                        ) {
                            Text(
                                text = "Vocabulary",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(
                                text = "Listen To 20 Words",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.size(10.dp))

                            Button(
                                modifier = Modifier
                                    .size(height = 30.dp, width = 60.dp)
                                    .clip(RoundedCornerShape(2)),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White

                                ),
                                onClick = {}) {
                                Text(
                                    text = "start ",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(modifier = Modifier.size(5.dp))

                                Box(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(
                                            CircleShape
                                        )
                                        .background(Color.Black),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        modifier = Modifier,
                                        imageVector = Icons.Filled.PlayArrow,
                                        contentDescription = "",
                                        tint = Color.White
                                    )
                                }

                            }
                        }
                        Image(
                            painterResource(id = R.drawable.listen),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .clip(RoundedCornerShape(10))
                                .weight(1f, fill = true)
                        )
                    }
                }
                Text(
                    text = "Recomonded",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 10.dp),
                )
                LazyColumn(
                    modifier = Modifier.padding(end = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(3) {
                        Recommended()
                    }
                }

            }
        }
    }
}

@Composable
fun Genre(text: String) {
    var isSelected by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .background(
                if (isSelected) Color.Black else Color.Transparent
            )
            .clickable { isSelected = !isSelected }, contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = text,
            color = if (isSelected) Color.White else Color.Gray,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold

        )
    }

}

@Composable
fun Recommended() {
    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20))
//            .background(colorResource(id = R.color.seal)),
        , contentAlignment = Alignment.Center

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20))
                    .background(colorResource(id = R.color.orange)),
                contentAlignment = Alignment.Center

            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Chatting",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "5 Minutes",
                    color = Color.Gray,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { isSelected = !isSelected }) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "",
                    tint = if (isSelected) Color.Yellow else Color.LightGray,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
