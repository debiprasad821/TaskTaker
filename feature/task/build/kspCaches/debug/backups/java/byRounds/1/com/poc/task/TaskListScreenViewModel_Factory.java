package com.poc.task;

import com.poc.data.repository.TaskListRepository;
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
public final class TaskListScreenViewModel_Factory implements Factory<TaskListScreenViewModel> {
  private final Provider<TaskListRepository> taskListRepositoryProvider;

  public TaskListScreenViewModel_Factory(Provider<TaskListRepository> taskListRepositoryProvider) {
    this.taskListRepositoryProvider = taskListRepositoryProvider;
  }

  @Override
  public TaskListScreenViewModel get() {
    return newInstance(taskListRepositoryProvider.get());
  }

  public static TaskListScreenViewModel_Factory create(
      Provider<TaskListRepository> taskListRepositoryProvider) {
    return new TaskListScreenViewModel_Factory(taskListRepositoryProvider);
  }

  public static TaskListScreenViewModel newInstance(TaskListRepository taskListRepository) {
    return new TaskListScreenViewModel(taskListRepository);
  }
}
