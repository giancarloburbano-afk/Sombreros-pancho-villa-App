package com.example.sombreros_pancho_villa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.sombreros_pancho_villa.ui.theme.SombrerospanchovillaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SombrerospanchovillaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PanchoVillaApp()
                }
            }
        }
    }
}

@Composable
fun PanchoVillaApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "🤠 Pancho Villa 🤠",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sombreros",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = {
                Text("Buscar productos")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Sombreros Disponibles",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        // AQUI completamos los parámetros para el primer sombrero
        ProductCard(
            name = "Sombrero Aguadeño",
            precio = 99000.0,
            imagen = R.drawable.aguadeno,
            descripcion = "Realizado 100% a mano"
        )

        Spacer(modifier = Modifier.height(24.dp))

        // AQUI completamos los parámetros para el segundo sombrero
        ProductCard(
            name = "Sombrero Costeño",
            precio = 35000.0,
            imagen = R.drawable.costeno,
            descripcion = "Un estilo fresco y diferente"
        )
    }
}

// La función ahora recibe las variables correctamente
@Composable
fun ProductCard(name: String, precio: Double, imagen: Int, descripcion: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
       Column(
           modifier = Modifier.padding(16.dp)
       ) {
           Image(
               // Aquí usamos la variable 'imagen' que llega por parámetro
               painter = painterResource(id = imagen),
               contentDescription = name, // Usamos el nombre para la descripción
               modifier = Modifier
                   .fillMaxWidth()
                   .height(200.dp)
           )

           Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                // Aquí usamos la variable 'descripcion'
                text = descripcion,
                style = MaterialTheme.typography.bodyMedium
            )

           Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    // Interpolamos el texto con el símbolo de peso y la variable precio
                    text = "Precio: \$${precio}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Button(
                    onClick = {  }
                ) {
                    Text("Comprar")
                }
            }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun PanchoVillaAppPreview() {
    SombrerospanchovillaTheme {
        PanchoVillaApp()
    }
}