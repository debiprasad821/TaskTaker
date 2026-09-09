package com.poc.work;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class TaskReminderScheduler_Factory implements Factory<TaskReminderScheduler> {
  private final Provider<Context> contextProvider;

  public TaskReminderScheduler_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public TaskReminderScheduler get() {
    return newInstance(contextProvider.get());
  }

  public static TaskReminderScheduler_Factory create(Provider<Context> contextProvider) {
    return new TaskReminderScheduler_Factory(contextProvider);
  }

  public static TaskReminderScheduler newInstance(Context context) {
    return new TaskReminderScheduler(context);
  }
}
