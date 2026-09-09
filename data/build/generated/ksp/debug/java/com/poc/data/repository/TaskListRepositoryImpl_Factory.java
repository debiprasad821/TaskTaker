package com.poc.data.repository;

import com.poc.data.local.TaskDao;
import com.poc.work.TaskReminderScheduler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class TaskListRepositoryImpl_Factory implements Factory<TaskListRepositoryImpl> {
  private final Provider<TaskDao> taskDaoProvider;

  private final Provider<TaskReminderScheduler> taskReminderSchedulerProvider;

  public TaskListRepositoryImpl_Factory(Provider<TaskDao> taskDaoProvider,
      Provider<TaskReminderScheduler> taskReminderSchedulerProvider) {
    this.taskDaoProvider = taskDaoProvider;
    this.taskReminderSchedulerProvider = taskReminderSchedulerProvider;
  }

  @Override
  public TaskListRepositoryImpl get() {
    return newInstance(taskDaoProvider.get(), taskReminderSchedulerProvider.get());
  }

  public static TaskListRepositoryImpl_Factory create(Provider<TaskDao> taskDaoProvider,
      Provider<TaskReminderScheduler> taskReminderSchedulerProvider) {
    return new TaskListRepositoryImpl_Factory(taskDaoProvider, taskReminderSchedulerProvider);
  }

  public static TaskListRepositoryImpl newInstance(TaskDao taskDao,
      TaskReminderScheduler taskReminderScheduler) {
    return new TaskListRepositoryImpl(taskDao, taskReminderScheduler);
  }
}
