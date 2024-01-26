package com.anmg.examen_progii

import android.text.method.TextKeyListener.Capitalize
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddNewReading(navController: NavController){
    // -- Variables declaradas --
    var readingMeter by remember { mutableStateOf("")}
    var dateReading by remember{ mutableStateOf("")}
    val serviceOptions = listOf(stringResource(id = R.string.water_type), stringResource(id = R.string.electricity_type), stringResource(
        id = R.string.gas_type))
    var selectedService by remember { mutableStateOf(serviceOptions[0])}


    // -- UI/UX y Lógica --
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp,20.dp )
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                /*.verticalScroll(rememberScrollState())*/
        ) {
            Text(stringResource(id = R.string.title_reading),
                fontWeight = FontWeight.Black,
                fontSize = 30.sp
            )
            Spacer(modifier=Modifier.height(20.dp))
            TextField(
                value = readingMeter,
                onValueChange = {readingMeter = it},
                label = {Text(stringResource(id = R.string.reading_meter))},
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )

            TextField(
                value = dateReading,
                onValueChange = {dateReading = it},
                label = {Text(stringResource(id = R.string.date_reading))}
            )

            Spacer(modifier=Modifier.height(30.dp))

            Text(
                text=stringResource(id = R.string.reading_type),
                modifier = Modifier.align(Alignment.Start)
            )

            serviceOptions.forEach { serviceName ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    RadioButton(
                        selected = (serviceName == selectedService),
                        onClick = { selectedService = serviceName }
                    )
                    Text(text = serviceName)
                }
            }

            Spacer(modifier=Modifier.height(60.dp))

            Button(onClick = {
                navController.navigate("home")
            /*TODO*/ }) {
                Text(text= stringResource(id = R.string.record_reading))
            }
            //RadioButton(selected = , onClick = { /*TODO*/ })
        }
    }

}
