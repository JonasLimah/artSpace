package com.jonaslimah.artspace

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jonaslimah.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtLayout()
                }
            }
        }
    }


    @Composable
    fun ArtLayout(modifier: Modifier = Modifier) {
        Row() {

        }
        Column(modifier) {
            var currentImg by remember {
                mutableStateOf(0)
            }
            var currentTitle by remember {
                mutableStateOf(0)
            }
            var currentDescription by remember {
                mutableStateOf(0)
            }
            var count by remember {
                mutableStateOf(1)
            }

            when (count) {
                1 -> {
                    currentImg = R.drawable.img1
                    currentTitle = R.string.image1_title
                    currentDescription = R.string.image1_description
                }

                2 -> {
                    currentImg = R.drawable.img2
                    currentTitle = R.string.image2_title
                    currentDescription = R.string.image2_description
                }

                3 -> {
                    currentImg = R.drawable.img3
                    currentTitle = R.string.image3_title
                    currentDescription = R.string.image3_description
                }

                4 -> {
                    currentImg = R.drawable.img4
                    currentTitle = R.string.image4_title
                    currentDescription = R.string.image4_description
                }

                5 -> {
                    currentImg = R.drawable.img5
                    currentTitle = R.string.image5_title
                    currentDescription = R.string.image5_description
                }

                else -> {
                    currentImg = R.drawable.img1
                    currentTitle = R.string.image1_title
                    currentDescription = R.string.image1_description
                }
            }
            Column(
                modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shadowElevation = 18.dp,
                    modifier = modifier
                        .padding(8.dp)
                        .height(500.dp),
                    shape = ShapeDefaults.Small,

                    ) {
                    Image(
                        painter = painterResource(id = currentImg),
                        contentDescription = stringResource(id = currentTitle),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = modifier
                    )
                }


            }


            Row(
                modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween


            ) {
                Column(
                    modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = currentTitle),
                        Modifier.padding(bottom = 18.dp),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = currentDescription),
                        Modifier.weight(2f),
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Row(
                        modifier
                            .fillMaxSize()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween


                    ) {
                        Button(
                            onClick = {
                                if (count > 1) {
                                    count--
                                    Log.i("previous", "$count")
                                }
                            },
                            modifier = modifier
                                .weight(1f)
                                .padding(horizontal = 20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            border = BorderStroke(2.dp, Color.Black)

                        ) {
                            Text(
                                text = "Previous",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }

                        Button(
                            onClick = {
                                if (count < 5) {
                                    count++
                                    Log.i("next", "$count")
                                }
                            },
                            modifier = modifier
                                .weight(1f)
                                .padding(horizontal = 20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            border = BorderStroke(2.dp, Color.Black)


                        ) {
                            Text(
                                text = "Next",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }
                    }

                }

            }

        }
    }


    @Preview(
        showBackground = true,
        showSystemUi = true
    )
    @Composable
    fun GreetingPreview() {
        ArtSpaceTheme {
            ArtLayout()
        }
    }
}