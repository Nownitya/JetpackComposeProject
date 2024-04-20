package com.nowni.jetpackcomposeproject.apps_list2.unscramble_initial.ui

import android.app.Activity
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.apps_list2.unscramble_initial.ui.theme.UnscrambleTheme

@Composable
fun GameScreen(gameViewModel:GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(mediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(id = R.string.unscramble_initial),
            style = typography.titleLarge,
            modifier = Modifier.padding(bottom = 20.dp, top = 5.dp)
        )

        GameLayout(
            currentScrambledWord = gameUiState.currentScrambleWord,
            wordCount = gameUiState.currentWordCount,
            isGuessWrong = gameUiState.isGuessedWordWrong,
            userGuess = gameViewModel.userGuess,
            onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
            onKeyboardDone = { gameViewModel.checkUserGuess() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(mediumPadding)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { gameViewModel.checkUserGuess() })
            {
                Text(
                    text = stringResource(id = R.string.submit),
                    fontSize = 16.sp
                )
            }
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { gameViewModel.skipWord() }
            ) {
                Text(
                    text = stringResource(id = R.string.skip),
                    fontSize = 16.sp
                )
            }
        }
        GameStatus(score = gameUiState.score, modifier = Modifier.padding(20.dp))

        if (gameUiState.isGameOver) {
            FinalScoreDialog(score = gameUiState.score,
                onPlayAgain = { gameViewModel.resetGame() })
        }

    }
}

@Composable
fun GameStatus(score: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.score, score),
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun GameLayout(
    currentScrambledWord: String,
    wordCount: Int,
    isGuessWrong: Boolean,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier
) {

    val mediumPadding = dimensionResource(R.dimen.padding_medium)

    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(mediumPadding)
        ) {
            Text(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = stringResource(id = R.string.word_count, wordCount),
                style = typography.titleMedium,
                color = colorScheme.onPrimary
            )

            Text(
                text = currentScrambledWord, style = typography.displayLarge
            )
            Text(
                text = stringResource(id = R.string.instructions),
                textAlign = TextAlign.Center,
                style = typography.titleMedium
            )
            OutlinedTextField(value = userGuess,
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorScheme.surface,
                    unfocusedContainerColor = colorScheme.surface,
                    disabledPlaceholderColor = colorScheme.surface
                ),
                onValueChange = onUserGuessChanged,
                label = {
                    if (isGuessWrong) {
                        Text(text = stringResource(id = R.string.wrong_guess))
                    } else {
                        Text(text = stringResource(id = R.string.enter_your_word))
                    }
                },
                isError = isGuessWrong,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    onKeyboardDone()
                }

                ))
        }
    }
}

@Composable
fun FinalScoreDialog(
    score: Int, onPlayAgain: () -> Unit, modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(onDismissRequest = { /*TODO*/ },
        title = { Text(text = stringResource(id = R.string.congratulations)) },
        text = { Text(text = stringResource(id = R.string.you_scored, score)) },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = {
                activity.finish()
            }) {
                Text(text = stringResource(id = R.string.exit))

            }
        },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(text = stringResource(id = R.string.play_again))
            }
        })
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GameScreenPreviewDark() {
    UnscrambleTheme {
        Surface {
            GameScreen()
        }
    }


}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun GameScreenPreviewLight() {
    UnscrambleTheme {
        Surface {
            GameScreen()
        }
    }

}