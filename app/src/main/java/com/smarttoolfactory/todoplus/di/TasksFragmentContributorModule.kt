package com.smarttoolfactory.todoplus.di


import com.smarttoolfactory.todoplus.tasks.map.TaskMapFragment
import com.smarttoolfactory.todoplus.tasks.list.TaskListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * TasksFragmentContributorModule is used inside ActivityContributorModule
 * With @ContributesAndroidInjector(modules = TasksFragmentContributorModule.class)
 * defines which module will be used to inject objects to declared fragments
 */
@Module
abstract class TasksFragmentContributorModule {

    @ContributesAndroidInjector
    abstract fun contributeTaskMapFragment(): TaskMapFragment

    @ContributesAndroidInjector
    abstract fun contributeTaskListFragment(): TaskListFragment
}

