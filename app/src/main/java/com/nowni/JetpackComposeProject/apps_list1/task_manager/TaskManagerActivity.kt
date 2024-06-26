package com.nowni.JetpackComposeProject.apps_list1.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.JetpackComposeProject.apps_list1.task_manager.ui.theme.TaskManagerTheme

class TaskManagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    TaskCompletedScreen2()
                    TaskManagerApp()

                }
            }
        }
    }
}


@Composable
fun TaskManagerApp() {
    TaskCompletedScreen(
        image = painterResource(R.drawable.ic_task_completed),
        title = stringResource(R.string.all_tasks_completed),
        description = stringResource(R.string.nice_work)
    )

}

@Composable
fun TaskCompletedScreen(
    image: Painter,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = description,
            fontSize = 16.sp
        )
    }
}

@Composable
fun TaskCompletedScreen2() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.all_tasks_completed),
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Task Manager"
)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
//        TaskManagerApp()
        TaskCompletedScreen2()
    }
}