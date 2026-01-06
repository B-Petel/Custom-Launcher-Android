import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import androidx.lifecycle.ViewModel

class HomeViewModel(
    private val context: Context
) : ViewModel() {
    val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
    val flags = PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_ALL.toLong())
    val activities: List<ResolveInfo> = context.packageManager.queryIntentActivities(intent, flags)

    fun getAppList(): List<AppData> {
        return activities.map { resolveInfo ->
            AppData(
                name = resolveInfo.loadLabel(context.packageManager).toString(),
                packageName = resolveInfo.activityInfo.packageName
            )
        }
    }
}