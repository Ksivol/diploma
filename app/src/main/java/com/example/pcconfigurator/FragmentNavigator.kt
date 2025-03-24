package com.example.pcconfigurator

import android.util.Log
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.github.terrakok.cicerone.Back
import com.github.terrakok.cicerone.BackTo
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.FragmentScreen

class FragmentNavigator(
    private val containerId: Int,
    private val fragmentManager: FragmentManager,
    private val tag: String,
    private val fragmentFactory: FragmentFactory = fragmentManager.fragmentFactory
) : Navigator {
    override fun applyCommands(commands: Array<out Command>) {
        fragmentManager.commit {
            commands.forEach {
                try {
                    applyCommand(it)
                } catch (e: RuntimeException) {
                    Log.e(this@FragmentNavigator::class.simpleName, e.message.toString())
                }
            }
        }
    }

    private fun FragmentTransaction.applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Replace -> replace(command)
            is BackTo -> backTo(command)
            is Back -> back()
        }
    }

    //[Forward, Back, Replace, BackTo, Forward]

    private fun FragmentTransaction.forward(command: Forward) {
        val screen = command.screen as FragmentScreen
        fragmentManager.findFragmentById(fragmentManager.backStackEntryCount-1)?.let { hide(it) }
        replace(containerId, createFragment(screen))
        addToBackStack("${tag}_${screen.screenKey}")
    }

    private fun back() {
        fragmentManager.popBackStack()
    }

    private fun backTo(command: BackTo) {
        val screen = command.screen
        if (screen == null)
            fragmentManager.popBackStack("${tag}_root", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        else
            fragmentManager.popBackStack("${tag}_${screen.screenKey}", FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun FragmentTransaction.replace(command: Replace) {
        replace(containerId, createFragment(command.screen as FragmentScreen))
    }

    private fun createFragment(screen: FragmentScreen) = screen.createFragment(fragmentFactory)
}