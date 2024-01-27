package com.anmg.examen_progii

import android.graphics.drawable.Icon
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ElectricMeter
import androidx.compose.material.icons.filled.EmojiObjects
import androidx.compose.material.icons.filled.GasMeter
import androidx.compose.material.icons.filled.Propane
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun ShowReadings(navController:NavController){
    Box(
        modifier=Modifier
            .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(30.dp)){
            LazyColumn{
                /*
                * BORRAR LUEGO QUE SE LOGRE PERSISTIR
                * SOLO VISUALIACIÓN
                * */
                item{
                    Text(text="HARCODED STRING")
                }
                //Iterar por sobre la base de datos?
                item {
                    Icon(Icons.Filled.WaterDrop, contentDescription = null)
                }
                item{
                    Icon(Icons.Default.EmojiObjects, contentDescription = null)
                }
                item{
                    Icon(Icons.Default.Propane, contentDescription = null)
                }
            }
        }
        Button(
            onClick = {
                navController.navigate("reading-meter")
                Log.v("BTN::READING SCREEN", "Navigating...")

                      /*TODO*/
                      },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(25.dp)
                //.size(60.dp, 60.dp)
            ) {
            Icon(
                Icons.Default.Add,
                contentDescription = stringResource(id = R.string.add_new_reading),
                modifier = Modifier.size(45.dp)
            )
        }
    }
}