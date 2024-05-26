package com.example.caps1stfan_quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.caps1stfan_quiz.ui.theme.Caps1stFan_QuizTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Caps1stFan_QuizTheme {
                DisplayQuestion()
            }
        }
    }
}

val oswald = FontFamily(
    Font(R.font.oswald_bold, FontWeight.Bold),
    Font(R.font.oswald_light, FontWeight.Light),
    Font(R.font.oswald_extralight, FontWeight.ExtraLight),
    Font(R.font.oswald_medium, FontWeight.Medium),
    Font(R.font.oswald_regular, FontWeight.Normal),
    Font(R.font.oswald_semibold, FontWeight.SemiBold)
)

@Composable
fun DisplayQuestion() {
    val quizItem = Quiz().getQuestion()
    val question = quizItem.question
    val options = quizItem.options
    val correct = quizItem.correctAnswer
    val result: MutableState<String> = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = question,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontFamily = oswald,
            fontWeight = FontWeight.Bold,
        )
            for (option in options) {
                TextButton(
                    onClick = {
                        result.value = if (options[correct] == option) "Correct!" else "Wrong!"
                    },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
//                        .wrapContentSize(Alignment.Center)
                        .padding(30.dp).weight(1f)
                        .background(Color.Black)
                        .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .height(5.dp)

                ) { Text(text = option) }
                Text(text = result.value)
            }
        }
    }





@Preview(showBackground = true)
@Composable
fun DisplayQuestionPreview() {
    Caps1stFan_QuizTheme {
        DisplayQuestion()
    }
}