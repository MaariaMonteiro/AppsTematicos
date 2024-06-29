package com.example.pag2

import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import com.example.pag2.ui.theme.Pag2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pag2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        //VARIÁVEIS DE TEXFIELD
        var nome by remember { mutableStateOf("") }

        // Row com a imagem e o título
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(56.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Duda shoes",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.DarkGray
                )
            )
        }

        // Imagem com borda arredondada
        Card(
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp),


            shape = MaterialTheme.shapes.medium // Define o shape com bordas arredondadas
        ) {
            Image(
                painter = painterResource(id = R.drawable.tenis6),
                contentDescription = "Tênis 6",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentScale = ContentScale.Crop
            )
        }

        // Adicionando Descrição
        Text(
            text = "Descrição: Tênis esportivo de alta performance.",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        )

        // Adicionando Preço
        Text(
            text = "Preço: R\$ 199,99                                                          ",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        )


        OutlinedTextField(
            value = "",
            onValueChange = { /* Lógica para lidar com a mudança de valor */ },
            label = { Text("Consulte o frete:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { /* Lógica para lidar com a mudança de valor */ },
            label = { Text("Quantidade:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Row (
            Modifier.padding(16.dp)
        ){
            Button (
                onClick = {/* TODO */ },
                modifier = Modifier

                    .size(width = 170.dp, height = 50.dp)

            ){

                Text(text = "Comprar",
                        modifier = Modifier,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Monospace,
                        ))




            }
        }

    }
    }


@Composable
fun GreetingPreview() {
    Pag2Theme {
        Greeting(name = "Android")
    }
}
