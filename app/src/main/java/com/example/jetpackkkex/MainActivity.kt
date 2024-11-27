package com.example.jetpackkkex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackkkex.ui.theme.JetpackkkexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackkkexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventDetailsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventDetailsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Event Image
        Image(
            painter = painterResource(id = R.drawable.event_image), // Replace with your image resource
            contentDescription = "Event Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

        // Event Title and Location
        Text(
            text = "Tech Conference 2024",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Mehsana, Gujarat | 2.5 km away",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Event Description
        Text(
            text = "This is a detailed description of the event. Learn, network, and explore the latest trends in technology.",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Event Schedule
        Text(
            text = "Event Schedule",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        ScheduleCard(time = "10:00 AM", title = "Keynote Speech")
        ScheduleCard(time = "11:30 AM", title = "Networking Session")

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /* TODO: Add Buy Tickets action */ }) {
                Text(text = "Buy Tickets")
            }
            Button(onClick = { /* TODO: Add Add to Calendar action */ }) {
                Text(text = "Add to Calendar")
            }
        }

        // Reviews Section
        Text(
            text = "Reviews",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(5) { index ->
                ReviewCard(reviewText = "This event was amazing! So much to learn.", reviewerName = "User $index")
            }
        }
    }
}

@Composable
fun ScheduleCard(time: String, title: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = time, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(text = title, fontSize = 14.sp)
        }
    }
}

@Composable
fun ReviewCard(reviewText: String, reviewerName: String, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = reviewerName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = reviewText,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailsPreview() {
    JetpackkkexTheme  {
        EventDetailsScreen()
    }
}