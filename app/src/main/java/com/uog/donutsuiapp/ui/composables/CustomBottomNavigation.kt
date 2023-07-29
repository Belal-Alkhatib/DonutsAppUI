package com.uog.donutsuiapp.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.navigation.Screen
import com.uog.donutsuiapp.navigation.ScreenItem
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.White

@Composable
fun CustomBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
    screenItems: List<ScreenItem> = BottomNavMenu()
) {

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        contentColor = Primary,
        containerColor = White
    ) {

        screenItems.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(indicatorColor = White),
                icon = {
                    Icon(
                        if (selectedItem == index)
                            painterResource(id = item.selectedIcon)
                        else
                            painterResource(id = item.unSelectedIcon),
                        contentDescription = item.rout,
                        tint = Primary
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.rout) {
                        navController.graph.startDestinationRoute?.let { startDestination ->
                            popUpTo(startDestination) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }


    }
}


@Composable
private fun BottomNavMenu(): List<ScreenItem> {
    return listOf(
        ScreenItem(
            Screen.HomeScreen.rout,
            selectedIcon = R.drawable.ic_filled_home,
            unSelectedIcon = R.drawable.ic_home
        ),
        ScreenItem(
            Screen.FavoriteScreen.rout,
            selectedIcon = R.drawable.ic_filled_heart,
            unSelectedIcon = R.drawable.ic_heart
        ),
        ScreenItem(
            Screen.NotificationScreen.rout,
            selectedIcon = R.drawable.ic_filled_notification,
            unSelectedIcon = R.drawable.ic_notification
        ),
        ScreenItem(
            Screen.BuyScreen.rout,
            selectedIcon = R.drawable.ic_filled_buy,
            unSelectedIcon = R.drawable.ic_buy
        ),
        ScreenItem(
            Screen.ProfileScreen.rout,
            selectedIcon = R.drawable.ic_filled_user,
            unSelectedIcon = R.drawable.ic_user
        )
    )
}