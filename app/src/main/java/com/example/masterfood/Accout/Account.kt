package com.example.masterfood.Accout
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.MoreVert

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masterfood.R



@Preview
@Composable
fun PrefileScreen(){
        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopBar(screen_name = "Account")

            Spacer(modifier = Modifier.height(16.dp))
            ProfileSection()

//   ================= Add Data Infor ============================================
            Spacer(modifier = Modifier.height(32.dp))
            Info("Info", "25", "male", "+856 20 29798435")
        }
    }



@Composable

fun TopBar(
    screen_name: String,
    modifier: Modifier = Modifier,

){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()

    ){
        Text(text = screen_name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "setting"
        )


    }
}


///Profile====================
@Composable

fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ){

            //image
            RoundImage(image = painterResource(
                id = R.drawable.logo), modifier = Modifier
                .size(50.dp)
                .weight(3f))

            Spacer(modifier = Modifier.height(4.dp))
//   ================= Username ============================================
            ProfileName("sompghong", "chanthamixay")
        }
    }

}


///image=============================

@Composable

fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp))
}

//=============================

@Composable
fun  ProfileName(
    name: String,
    lastname: String,
    modifier: Modifier = Modifier
){
    Row (
        horizontalArrangement = Arrangement.End,
        modifier = modifier
    ){
        Text(text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(text = lastname,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
//

@Composable
fun  Info(
    title: String,
    age: String,
    gender: String,
    phone: String,
    modifier: Modifier = Modifier
){
    Column (
//        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxWidth()
    ){
        Text(text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row (
//            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            Text(text = "age",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Text(text = age,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
//            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            Text(text = "gender",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Text(text = gender,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
//            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            Text(text = "phone",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Text(text = phone,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            Text(text = "Log Out",
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}



