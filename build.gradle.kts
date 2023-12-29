// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    libs.apply {
        alias(plugins.androidApplication) apply false
        alias(plugins.kotlinAndroid) apply false
        alias(plugins.ksp) apply false
        alias(plugins.hilt.plugin) apply false
    }
}
true // Needed to make the Suppress annotation work for the plugins block