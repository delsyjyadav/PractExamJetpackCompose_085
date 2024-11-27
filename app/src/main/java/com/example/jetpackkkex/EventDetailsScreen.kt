package com.example.jetpackkkex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EventDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Entire screen scrollable
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(16.dp))
        EventSchedule()
        Spacer(modifier = Modifier.height(16.dp))
        ReviewsSection()
        Spacer(modifier = Modifier.height(16.dp))
        ActionButtons()
    }
}

@Composable
fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.event), // Add event image to res/drawable
            contentDescription = "Event Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp) // Increased image height for better visuals
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tech Conference 2024",
            fontSize = 28.sp, // Larger font for the title
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Mehsana, Gujarat | 2.5 km away",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "This is a detailed description of the event...",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun EventSchedule() {
    Text(
        text = "Event Schedule",
        fontSize = 22.sp, // Larger font for section title
        fontWeight = FontWeight.Bold
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        EventCard("10:00 AM", "Keynote Speech", "Keynote by our esteemed speaker")
        EventCard("11:30 AM", "Networking Session", "Meet and connect with professionals")
        EventCard("1:00 PM", "Panel Discussion", "Insights from industry experts")
    }
}

@Composable
fun EventCard(time: String, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), // Increased padding for spacing
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp) // Higher elevation for better appearance
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(text = time, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1976D2))
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ReviewsSection() {
    Text(
        text = "Reviews",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        ReviewCard("Alice Johnson", 5, "Great event! Well-organized and informative.")
        ReviewCard("Bob Smith", 4, "Really enjoyed the keynote speaker. Would recommend!")
        ReviewCard("Charlie Davis", 3, "Good event overall, but some sessions were too short.")
        ReviewCard("Daniel Brown", 5, "Absolutely amazing! A must-attend.")
    }
}

@Composable
fun ReviewCard(name: String, rating: Int, comment: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = "⭐".repeat(rating), fontSize = 14.sp, color = Color(0xFFFFC107)) // Stars for rating
            Text(text = comment, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { /* TODO: Add ticket logic */ }) {
            Text(text = "Buy Tickets")
        }
        Button(onClick = { /* TODO: Add calendar logic */ }) {
            Text(text = "Add to Calendar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventDetailsScreen() {
    EventDetailsScreen()
}