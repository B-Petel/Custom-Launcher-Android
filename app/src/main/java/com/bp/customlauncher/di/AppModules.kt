import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val appModule = module {
    //viewModel { HomeViewModel(androidApplication()) }

    viewModelOf(::HomeViewModel)
}