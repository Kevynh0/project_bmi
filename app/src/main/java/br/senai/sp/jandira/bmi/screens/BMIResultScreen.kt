package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun  BMIResultScreen(
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF008EFF),
                            Color(0x2000BBFF)
                        )
                    )
                )
        ){
            Text(
                text = stringResource(
                    R.string.bmi_result
                ),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(40.dp)
                    .weight(1f)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    ),
                shape = RoundedCornerShape( //Arredonda as quinas do card
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card(
                        modifier = Modifier
                            .size(120.dp),
                        colors = CardDefaults
                            .cardColors(
                                containerColor = Color.White
                            ),
                        shape = CircleShape,                //Transforma o quadrado em circulo
                        border = BorderStroke(              //Faz a borda da borda rsrs
                            width = 7.dp,                   //Grossura do traço da borda
                            brush = Brush.linearGradient(   //Faz o Gradient entre duas ou mais cores
                                listOf(
                                    Color(0xFF008EFF),
                                    Color(0x2000BBFF)
                                )
                            )
                        )
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = stringResource(
                                    R.string.result
                                ),
                                fontSize = 40.sp,                 //Aumenta o tamanho do número
                                fontWeight = FontWeight.ExtraBold //Coloca o número em negrito
                            )
                        }
                    }
                    Text(
                        text = stringResource(
                            R.string.class1
                        ),
                        modifier = Modifier
                            .padding(top = 15.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black


                    )
                    Card(
                        modifier = Modifier
                            .width(370.dp)
                            .height(100.dp),
                        colors = CardDefaults
                            .cardColors(
                                containerColor = Color(0xAB7090FF)
                            )
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.age
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "17",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .padding(vertical = 10.dp),
                                color = Color.Gray
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.weight
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "53 Kg",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                            VerticalDivider( //Divisão cinza ao lado das Colunm's dentro da Row
                                modifier = Modifier
                                    .padding(vertical = 10.dp),
                                color = Color.Gray
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.height
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "163 cm",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            } //Fechamento da última Column
                        } //Fechamento da Row
                    } //Fechamento do Card de Age, Weight e Height
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(top = 10.dp)
                            .background(color = Color.LightGray)
                    ){  }
                    HorizontalDivider( //Divisão cinza abaixo da Colunm LightGray, de futuros dados
                        modifier = Modifier
                            .padding(top = 30.dp)
                    )
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF008EFF))
                    ){
                        Text(
                            text = stringResource(
                                R.string.new_calc
                            ),
                            fontSize = 25.sp
                        )
                    }
                } //Fechamento da Column fillmaxsize do Card White
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun BMIResultScreenPreview(){
    BMIResultScreen()
}