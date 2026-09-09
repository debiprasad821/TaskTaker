package com.poc.data.di;

import android.content.Context;
import com.poc.data.local.TaskDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideTaskDatabaseFactory implements Factory<TaskDatabase> {
  private final DatabaseModule module;

  private final Provider<Context> appContextProvider;

  public DatabaseModule_ProvideTaskDatabaseFactory(DatabaseModule module,
      Provider<Context> appContextProvider) {
    this.module = module;
    this.appContextProvider = appContextProvider;
  }

  @Override
  public TaskDatabase get() {
    return provideTaskDatabase(module, appContextProvider.get());
  }

  public static DatabaseModule_ProvideTaskDatabaseFactory create(DatabaseModule module,
      Provider<Context> appContextProvider) {
    return new DatabaseModule_ProvideTaskDatabaseFactory(module, appContextProvider);
  }

  public static TaskDatabase provideTaskDatabase(DatabaseModule instance, Context appContext) {
    return Preconditions.checkNotNullFromProvides(instance.provideTaskDatabase(appContext));
  }
}
