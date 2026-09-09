package com.poc.data.di;

import com.poc.data.local.TaskDao;
import com.poc.data.local.TaskDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideTaskDaoFactory implements Factory<TaskDao> {
  private final DatabaseModule module;

  private final Provider<TaskDatabase> taskDatabaseProvider;

  public DatabaseModule_ProvideTaskDaoFactory(DatabaseModule module,
      Provider<TaskDatabase> taskDatabaseProvider) {
    this.module = module;
    this.taskDatabaseProvider = taskDatabaseProvider;
  }

  @Override
  public TaskDao get() {
    return provideTaskDao(module, taskDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideTaskDaoFactory create(DatabaseModule module,
      Provider<TaskDatabase> taskDatabaseProvider) {
    return new DatabaseModule_ProvideTaskDaoFactory(module, taskDatabaseProvider);
  }

  public static TaskDao provideTaskDao(DatabaseModule instance, TaskDatabase taskDatabase) {
    return Preconditions.checkNotNullFromProvides(instance.provideTaskDao(taskDatabase));
  }
}
