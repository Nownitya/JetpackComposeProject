package com.nowni.jetpackcomposeproject

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.apps_list1.affirmations_initial_app.AffirmationsActivity
import com.nowni.jetpackcomposeproject.apps_list1.art_space_app.ArtSpaceAppActivity
import com.nowni.jetpackcomposeproject.apps_list1.birthday_card.BirthdayCardActivity
import com.nowni.jetpackcomposeproject.apps_list1.business_card.BusinessCardActivity
import com.nowni.jetpackcomposeproject.apps_list1.compose_article.ComposeArticleActivity
import com.nowni.jetpackcomposeproject.apps_list1.compose_quadrant.ComposeQuadrantActivity
import com.nowni.jetpackcomposeproject.apps_list1.courses.CoursesActivity
import com.nowni.jetpackcomposeproject.apps_list2.dessert_clicker_initial.DessertClickerInitialActivity
import com.nowni.jetpackcomposeproject.apps_list1.dice_roller_app.DiceRollerActivity
import com.nowni.jetpackcomposeproject.apps_list1.lemonade_app.LemonadeActivity
import com.nowni.jetpackcomposeproject.apps_list1.super_heroes.HeroesScreen
import com.nowni.jetpackcomposeproject.apps_list1.task_manager.TaskManagerActivity
import com.nowni.jetpackcomposeproject.apps_list1.tip_time_final.TipTimeFinalActivity
import com.nowni.jetpackcomposeproject.apps_list1.tip_time_starter.TipTimeInitialActivity
import com.nowni.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme
import com.nowni.jetpackcomposeproject.apps_list1.woof.WoofActivity
import com.nowni.jetpackcomposeproject.zdata.AppDataSource2
import com.nowni.jetpackcomposeproject.zmodel.AppLists

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ComposeProjectApp()
                }
            }
        }
    }
}

@Composable
fun ComposeProjectApp() {
    ComposeProjectList(AppDataSource2.appLists)
}


@Composable
fun ComposeProjectLayout(
    appList: AppLists, modifier: Modifier = Modifier, onItemClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .clickable { onItemClick(appList.listId) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = stringResource(id = appList.nameId),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                color = Color.Gray,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ComposeProjectList(appList: List<AppLists>, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    LazyColumn(modifier = modifier) {
        items(appList) { list ->
            ComposeProjectLayout(
                appList = list,
                onItemClick = { listId ->
                    val activityClass = when (listId) {
                        1 -> BirthdayCardActivity::class.java
                        2 -> BusinessCardActivity::class.java
                        3 -> ComposeArticleActivity::class.java
                        4 -> ComposeQuadrantActivity::class.java
                        5 -> LemonadeActivity::class.java
                        6 -> DiceRollerActivity::class.java
                        7 -> TaskManagerActivity::class.java
                        8 -> TipTimeFinalActivity::class.java
                        9 -> TipTimeInitialActivity::class.java
                        10 -> ArtSpaceAppActivity::class.java
                        11 -> CoursesActivity::class.java
                        12 -> AffirmationsActivity::class.java
                        13 -> WoofActivity::class.java
                        14 -> HeroesScreen::class.java
                        15 -> DessertClickerInitialActivity::class.java
                        else -> null
                    }
                    activityClass?.let {
                        context.startActivities(arrayOf(Intent(context, it)))
                    }
                })
        }
    }
}

/**
 *  1-> {
 *      val inten = Intent(context, BirthdayCardActivity::class.java)
 *      context.startActivity(inten)
 *  }
 */

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Project",
)
@Composable
fun AppsPreview1() {
    JetpackComposeProjectTheme(darkTheme = false) {
        Surface {
            //        val appList = AppList(R.string.activity_birthday_card_app)
//        ComposeProjectLayout(appList = appList)
            ComposeProjectApp()
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Project",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AppsPreview2() {
    JetpackComposeProjectTheme {
        Surface {
            //        val appList = AppList(R.string.activity_birthday_card_app)
//        ComposeProjectLayout(appList = appList)
            ComposeProjectApp()
        }

    }
}