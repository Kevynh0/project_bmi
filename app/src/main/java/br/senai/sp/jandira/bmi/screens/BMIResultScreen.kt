package br.senai.sp.jandira.bmi.screens

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.numberConvertToLocale

@Composable
fun  BMIResultScreen(navegacao: NavHostController?) {

    val userFile = LocalContext.current
        .getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userAge = userFile.getInt("user_age", 0)
    val userHeight = userFile.getFloat("user_height", 0.0f)
    val userWeight = userFile.getFloat("user_weight", 0.0f)


    // Obter os dados do IMC do usuário
    val result = bmiCalculate(userWeight.toInt(),
                           userHeight.toDouble().div(100)
    )

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
                            color = result.color
                        )
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                text = numberConvertToLocale(result.bmi.second),
                                fontSize = 40.sp,                 //Aumenta o tamanho do número
                                fontWeight = FontWeight.ExtraBold //Coloca o número em negrito
                            )
                        }
                    }
                    Text(
                        text = result.bmi.first,
                        modifier = Modifier
                            .padding(top = 15.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = result.color


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
                                    text = "$userAge",
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
                                    text = "$userWeight",
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
                                    text = "$userHeight",
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
//                            .height(200.dp)
                            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
                            .background(color = Color.Transparent)
                    ) {
                        BmiLevel(
                            leftText = "Underweight",
                            rightText = "<18.5",
                            bulletColor = colorResource(R.color.light_blue),
                            background = if (result.status == BmiStatus.UNDER_WEIGHT)
                                colorResource(R.color.light_blue) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Normal",
                            rightText = "18.6 - 24.9",
                            bulletColor = colorResource(R.color.light_green),
                            background = if (result.status == BmiStatus.NORMAL)
                                colorResource(R.color.light_green) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Overweight",
                            rightText = "25.0 - 29.9",
                            bulletColor = colorResource(R.color.yellow),
                            background = if (result.status == BmiStatus.OVER_WEIGHT)
                                colorResource(R.color.yellow) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Obesity Class I",
                            rightText = "30.0 - 34.9",
                            bulletColor = colorResource(R.color.light_orange),
                            background = if (result.status == BmiStatus.OBESITY_1)
                                colorResource(R.color.light_orange) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Obesity Class II",
                            rightText = "35.0 - 39.9",
                            bulletColor = colorResource(R.color.dark_orange),
                            background = if (result.status == BmiStatus.OBESITY_2)
                                colorResource(R.color.dark_orange) else Color.Transparent
                        )
                        BmiLevel(
                            leftText = "Obesity Class III",
                            rightText = ">39.9",
                            bulletColor = colorResource(R.color.light_red),
                            background = if (result.status == BmiStatus.OBESITY_3)
                                colorResource(R.color.light_red) else Color.Transparent
                        )
                    }

                    HorizontalDivider( //Divisão cinza abaixo da Colunm LightGray, de futuros dados
                        modifier = Modifier
                            .padding(top = 30.dp)
                    )
                    Button(
                        onClick = {navegacao?.navigate("home")},
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

@Preview
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}
