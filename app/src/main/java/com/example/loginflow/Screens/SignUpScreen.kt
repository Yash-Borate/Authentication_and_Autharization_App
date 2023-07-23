package com.example.loginflow.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.loginflow.R
import com.example.loginflow.app.BottomClickableTextComponent
import com.example.loginflow.app.ButtonComponent
import com.example.loginflow.app.CheckBoxComponent
import com.example.loginflow.app.DeviderComponent
import com.example.loginflow.app.GoogleAndFacebookLogin
import com.example.loginflow.app.HeadingTextComponent
import com.example.loginflow.app.MyTextField
import com.example.loginflow.app.PassMyTextField
import com.example.loginflow.app.TextComponent

@SuppressLint("ResourceType")
@Composable
fun SignUpScreen(navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TextComponent(text = stringResource(R.string.hey_there))
            HeadingTextComponent(text = stringResource(R.string.create_an_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                LabelValue = stringResource(R.string.first_name),
                painterResource(id = R.drawable.profile)
            )
            MyTextField(
                LabelValue = stringResource(R.string.last_name),
                painterResource(id = R.drawable.profile)
            )
            MyTextField(
                LabelValue = stringResource(R.string.email),
                painterResource(id = R.drawable.message)
            )
            PassMyTextField(
                LabelValue = stringResource(R.string.password),
                painterResource(id = R.drawable.lock))
            
            CheckBoxComponent()
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(R.string.register))
            Spacer(modifier = Modifier.height(15.dp))
            DeviderComponent()

            GoogleAndFacebookLogin()

            BottomClickableTextComponent(onTextSelected = {})

        }

    }
}

