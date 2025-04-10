package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(navegacao: NavHostController?) {

    //Recebe o valor digitado pelo usuário
    var ageState = remember {
        mutableStateOf("")
    }

    //Recebe o valor digitado pelo usuário
    var weightState = remember {
        mutableStateOf("")
    }

    //Recebe o valor digitado pelo usuário
    var heightState = remember {
        mutableStateOf("")
    }

    //Abrir ou fechar um arquivo do tipo SharedPreferences
    val context = LocalContext.current
    //Cria uma Val que recebe ...
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)
    //Cria uma variável que recebe o nome digitado na Screen anterior
    val userName = userFile.getString("user_name", "")

    val editor = userFile.edit()


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
        ) {
            Text(
                text = stringResource(
                    R.string.hi
                ) + ", $userName!",            //Concatenarção -
                // Faz com que apareça o nome digitado na página anterior junto à String hi.
                fontSize = 35.sp,               //Tamanho da font do Text
                fontWeight = FontWeight.Bold, //Negrito no Text
                modifier = Modifier
//                    .padding(50.dp)           //Forma simples de fazer
                    .padding(40.dp)             //Jeito Top
                    .weight(1f)                 //Jeito Top
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f), //.height(800.dp),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    ),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd =  30.dp,
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card(
                                modifier = Modifier
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF000000),
                                            Color(0xFF626262),
                                        )
                                    )
                                )
                            ){
                                Image(
                                    painter = painterResource(
                                        R.drawable.homem
                                    ),
                                    contentDescription = ""
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                colors = ButtonDefaults
                                    .buttonColors(
                                        containerColor = Color(0xFF0022FF)
                                    )
                            ) {
                                Text(
                                    text = stringResource(
                                        R.string.male
                                    )
                                )
                            }
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card(
                                modifier = Modifier
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF000000),
                                            Color(0xFF626262),
                                        )
                                    )
                                )
                            ){
                                Image(
                                    painter = painterResource(
                                        R.drawable.mulher
                                    ),
                                    contentDescription = ""
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                colors = ButtonDefaults
                                    .buttonColors(
                                        containerColor = Color(0xFF0022FF)
                                    )
                            ) {
                                Text(
                                    text = stringResource(
                                        R.string.female
                                    )
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {ageState.value = it},
                            modifier = Modifier
                                .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xFF0022FF)
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(
                                        R.string.age
                                    )
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            value = weightState.value, //-------------
                            onValueChange = {weightState.value = it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xFF0022FF)
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(
                                        R.string.weight
                                    )
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {heightState.value = it},
                            modifier = Modifier
                                .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(0xFF0022FF)
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(
                                        R.string.height
                                    )
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )
                    }
                    Button(
                        onClick = {
                            editor.putInt("user_age", ageState.value.toInt())
                            editor.putFloat("user_weight", weightState.value.toFloat())
                            editor.putFloat("user_height", heightState.value.toFloat())
                            editor.apply()
                            navegacao?.navigate("bmi_result")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0022FF)
                        )
                    ){
                        Text(
                            text = stringResource(
                                R.string.calculate
                            ),
                        )
                    }
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen(null)
}