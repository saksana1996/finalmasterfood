package com.example.masterfood.Accout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert

import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masterfood.R



@Preview
@Composable
fun PrefileScreen(){
        Column (
            modifier = Modifier
                .padding(16.dp)
        ) {
            //Title App
            TopBar(screen_name = "Account")

            Spacer(modifier = Modifier.height(16.dp))
            ProfileHeader()

//   ================= Add Data Infor ============================================
            Spacer(modifier = Modifier.height(32.dp))


            Info("Information", "25", "male", "+856 20 29798435")
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

//==============================================

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
//=====================Add information ===================
@Composable
fun  Info(
    title: String,
    age: String,
    gender: String,
    phone: String,
    backgroundColor: Color = Color(0xFFFFFFFF),

    modifier: Modifier = Modifier


){
    Column (
//        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
    ){
        Text(text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row (
//            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
                .background(backgroundColor)
                .padding(20.dp)
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
                .background(backgroundColor)
                .padding(20.dp)

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
            modifier = modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(20.dp)
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
            modifier = modifier.
            fillMaxWidth()
                .background(backgroundColor)
                .padding(20.dp)
        ){
            Text(text = "Log Out",
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

//===================Image username ==================

@Composable
fun ProfileHeader(
    imagePainter: Painter = painterResource( R.drawable.avatar),
    imageSize: Dp = 50.dp,
    imageShape: RoundedCornerShape = RoundedCornerShape(25.dp),
    name: String = "Somphong",
    lastname: String = "chanthamixay",
    titleFontSize: TextUnit = 20.sp,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,

        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)


    ) {
        Box(
            modifier = Modifier
                .size(imageSize)
                // 2. Box for Image Shaping
                .clip(imageShape)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .padding(3.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Row ( modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left){

            Text(
                text = name,
                fontSize = titleFontSize,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = lastname,
                fontSize = titleFontSize,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                textAlign = TextAlign.Center,
            )
        }
    }
}

