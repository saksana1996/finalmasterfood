package com.example.masterfood.Accout
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            ProfileHeader(User("1", "Somphong", "chanthamixay", "25", "male", "*856 20 2564 89"))

//   ================= Add Data Infor ============================================
            Spacer(modifier = Modifier.height(32.dp))
            Info(modifier = Modifier.height(42.dp), "Information")
            InfoList(userList = Datasource().loadUserInfo())

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



//=====================Info Titles ===================
@Composable
fun  Info(
    modifier: Modifier,
    title: String,
){
    Text(text = title,
        modifier = modifier
            .padding(8.dp),
        style = MaterialTheme.typography.titleLarge

    )
  }


@Composable
fun ProfileHeader( user: User ,
    imagePainter: Painter = painterResource( R.drawable.avatar),
    imageSize: Dp = 50.dp,
    imageShape: RoundedCornerShape = RoundedCornerShape(25.dp),
    name: String = user.name,
    lastname: String = user.lastname,
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

//=================== List Info ======================


@Composable
fun InfoCard(user: User, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, //Card background color
            contentColor = Color.Black  //Card content color,e.g.text
        )
    ) {
        Column {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(100.dp))
                    .drawBehind {
                        val strokeWidthPx = 1.dp.toPx()
                        val verticalOffset = size.height - 2.sp.toPx()
                        drawLine(
                            color = Color.LightGray,
                            strokeWidth = strokeWidthPx,
                            start = Offset(0f, verticalOffset),
                            end = Offset(size.width, verticalOffset)
                        )
                    },
            ){
                Text(
                    text = "Age:",
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = user.gae,
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(100.dp))
                    .drawBehind {
                        val strokeWidthPx = 1.dp.toPx()
                        val verticalOffset = size.height - 2.sp.toPx()
                        drawLine(
                            color = Color.LightGray,
                            strokeWidth = strokeWidthPx,
                            start = Offset(0f, verticalOffset),
                            end = Offset(size.width, verticalOffset)
                        )
                    },
            ){
                Text(
                    text = "Gender:",
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = user.gnder,
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium

                )
            }

            Row (

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(100.dp))
                    .drawBehind {
                        val strokeWidthPx = 1.dp.toPx()
                        val verticalOffset = size.height - 2.sp.toPx()
                        drawLine(
                            color = Color.LightGray,
                            strokeWidth = strokeWidthPx,
                            start = Offset(0f, verticalOffset),
                            end = Offset(size.width, verticalOffset)
                        )
                    },
            ){
                Text(
                    text = "phone:",
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = user.phone,
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ){

                LogOut()
            }

        }
    }



}
@Composable
fun LogOut() {
    Button(onClick = { /* Do something */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color(0xFF009429),
            disabledContentColor = Color.Gray,)
        ) {

        Text(text = "Click Me")
    }
}





@Composable
fun InfoList(userList: List<User>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(userList) { affirmation ->
            InfoCard(
                user = affirmation,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}


//=======================  UserModel =======================

data class User(
    val user_id: String,
    val name: String,
    val lastname: String,
    val gae: String,
    val gnder: String,
    val phone: String,
    )

//=============  Datasource =================================

class Datasource() {
    fun loadUserInfo(): List<User> {
        return listOf<User>(
            User("1", "somphong", "chanthamixay", "27", "male", "856 20 29798435" )
        )
    }
}
