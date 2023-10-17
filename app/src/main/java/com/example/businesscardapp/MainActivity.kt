package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card(modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFFD2E8D4)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF3da9fc))
            ) {
            val image = painterResource(R.drawable.profile)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            }
            Text(
                text = stringResource(R.string.card_name),
                modifier = modifier,
                fontSize = 30.sp
            )
            Text(
                text = stringResource(R.string.card_job),
                color = Color(0xFF006734),
                fontWeight = FontWeight.ExtraBold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            ComposableContactCard(
                icon = Icons.Filled.Phone,
                desc = stringResource(R.string.card_phone),
                modifier  = Modifier.padding(bottom = 15.dp)
            )
            ComposableContactCard(
                icon = Icons.Filled.Share,
                desc = stringResource(R.string.card_social),
                modifier  = Modifier.padding(bottom = 15.dp)
            )
            ComposableContactCard(
                icon = Icons.Filled.Email,
                desc = stringResource(R.string.card_gmail),
                modifier  = Modifier.padding(bottom = 35.dp)
            )
        }
}

@Composable
fun ComposableContactCard(
    icon : ImageVector,
    desc : String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .padding(start = 60.dp)
            .then(modifier),
    ){
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF006734)
        )
        Text(
            text = desc,
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Card()
    }
}