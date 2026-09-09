package com.poc.work;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.poc.notifications.NotificationHelper;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class TaskReminderWorker_Factory {
  private final Provider<NotificationHelper> notificationHelperProvider;

  public TaskReminderWorker_Factory(Provider<NotificationHelper> notificationHelperProvider) {
    this.notificationHelperProvider = notificationHelperProvider;
  }

  public TaskReminderWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, notificationHelperProvider.get());
  }

  public static TaskReminderWorker_Factory create(
      Provider<NotificationHelper> notificationHelperProvider) {
    return new TaskReminderWorker_Factory(notificationHelperProvider);
  }

  public static TaskReminderWorker newInstance(Context context, WorkerParameters params,
      NotificationHelper notificationHelper) {
    return new TaskReminderWorker(context, params, notificationHelper);
  }
}
