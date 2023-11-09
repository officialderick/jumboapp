package com.example.jumboapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jumboapp.R
import com.example.jumboapp.navigations.ROUTE_BOOKSHELF
import com.example.jumboapp.navigations.ROUTE_CALCULATOR
import com.example.jumboapp.navigations.ROUTE_MUSIC
import com.example.jumboapp.ui.theme.JumboAppTheme


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Jumbo App",
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            content = {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 20.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Card(
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp),
                            elevation = CardDefaults
                                .cardElevation(defaultElevation = 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Red,
                            )
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_menu_book_24),
                                        contentDescription = "My icon",
                                        tint = Color.Cyan
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .height(70.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceEvenly
                                )
                                {
                                    Button(onClick = {
                                        navController.navigate(ROUTE_BOOKSHELF)
                                    }) {
                                        Text(text = "Bookshelf")

                                    }


                                }
                            }


                        }

                        Card(
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp),
                            elevation = CardDefaults
                                .cardElevation(defaultElevation = 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Red,
                            )
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_calculate_24),
                                        contentDescription = "My icon",
                                        tint = Color.Cyan
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .height(70.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceEvenly
                                )
                                {
                                    Button(onClick = {
                                        navController.navigate(ROUTE_CALCULATOR)
                                    }) {
                                        Text(text = "Calculator")

                                    }


                                }
                            }


                        }

                        Card(
                            modifier = Modifier
                                .width(150.dp)
                                .height(100.dp),
                            elevation = CardDefaults
                                .cardElevation(defaultElevation = 10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Red,
                            )
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_music_note_24),
                                        contentDescription = "My icon",
                                        tint = Color.Cyan
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .background(Color.White)
                                        .fillMaxWidth()
                                        .height(70.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceEvenly
                                )
                                {
                                    Button(onClick = {
                                        navController.navigate(ROUTE_MUSIC)
                                    }) {
                                        Text(text = "Music")

                                    }


                                }
                            }


                        }

                            BottomAppBar(
                                modifier = Modifier
                                    .background(Color.Gray),

                            ) {
                                Text(
                                    text = "Copyright © 2023 Your Company",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)

                                )
                            }


                        }
                    }

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JumboAppTheme{
        HomeScreen(rememberNavController())
    }
}


